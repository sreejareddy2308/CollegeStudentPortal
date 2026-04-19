package com.college.student.portal.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.AdminDTO;
import com.college.student.portal.dto.ApiResponse;
import com.college.student.portal.dto.JwtLoginResponse;
import com.college.student.portal.dto.LoginRequest;
import com.college.student.portal.entity.Admin;
import com.college.student.portal.enums.Role;
import com.college.student.portal.repository.AdminRepository;
import com.college.student.portal.security.AdminUserDetails;
import com.college.student.portal.security.JwtUtil;

@Service
public class AdminService {

	private final AdminRepository adminRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	private final AuthenticationManager authenticationManager;
	
	
	public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil,
			AuthenticationManager authenticationManager) {
		super();
		this.adminRepository = adminRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
		this.authenticationManager = authenticationManager;
	}

	// Register Admin
	public ResponseEntity<Map<String, Object>> registerAdmin(AdminDTO adminDto){
		
		Optional<Admin> isExistingAdmin = adminRepository.findByEmail(adminDto.getEmail());
		
		if(isExistingAdmin.isPresent()) {
			return ResponseEntity.status(HttpStatus.FOUND)
					.body(Map.of("message","This E-mail already exists, please try another one!"));
		}else {
			Admin admin = new Admin();
			admin.setName(adminDto.getName());
			admin.setEmail(adminDto.getEmail());
			admin.setPasswordHash(passwordEncoder.encode(adminDto.getPasswordHash()));
			admin.setPhone(adminDto.getPhone());
			
			admin.setRole(Role.ADMIN);
			
			adminRepository.save(admin);
			
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(Map.of("message","Admin Registration Successful!",
							"role",((Admin) admin).getRole()));
			
		}
	}
	
	// Login Admin
	public ResponseEntity<ApiResponse<JwtResponse>> loginAdmin(LoginRequest loginRequest){
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					loginRequest.getEmail(),
					loginRequest.getPassword()
					));
			
			Admin admin = adminRepository.findByEmail((String) loginRequest.getEmail())
					.orElseThrow(() -> new RuntimeException("Admin not found!"));
			
			AdminUserDetails userDetails = new AdminUserDetails(admin);
			
			String token = jwtUtil.createToken(userDetails.getUsername());
			
			JwtLoginResponse jwtResponse = new JwtLoginResponse();
			jwtResponse.setUsername(admin.getEmail());
			jwtResponse.setToken(token);
			jwtResponse.setRole(((Admin) admin).getRole());
			
			return ResponseEntity.ok(new ApiResponse <JwtResponse>(true,"Login successful!",jwtResponse
          ));
			
		}catch(BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse<>(
							false,
							"Invalid Credentials",
							null
							));
		}
	}
	
	
}
