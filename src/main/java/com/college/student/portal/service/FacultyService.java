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

import com.college.student.portal.dto.ApiResponse;
import com.college.student.portal.dto.FacultyDTO;
import com.college.student.portal.dto.JwtLoginResponse;
import com.college.student.portal.dto.LoginRequest;
import com.college.student.portal.entity.Faculty;
import com.college.student.portal.enums.Role;
import com.college.student.portal.repository.FacultyRepository;
import com.college.student.portal.security.FacultyUserDetails;
import com.college.student.portal.security.JwtUtil;

@Service
public class FacultyService {

	private final FacultyRepository facultyRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	private final AuthenticationManager authenticationManager;
	
	public FacultyService(FacultyRepository facultyRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil,
			AuthenticationManager authenticationManager) {
		super();
		this.facultyRepository = facultyRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
		this.authenticationManager = authenticationManager;
	}

	// Register Faculty
	public ResponseEntity<Map<String, Object>> registerFaculty(FacultyDTO facultyDto){
		
		Optional<Faculty> isExistingFaculty = facultyRepository.findByEmail(facultyDto.getEmail());
		
		if(isExistingFaculty.isPresent()) {
			return ResponseEntity.status(HttpStatus.FOUND)
					.body(Map.of("message","This E-mail already exists, please try another one!"));
		}else {
			Faculty faculty = new Faculty();
			faculty.setName(facultyDto.getName());
			faculty.setEmail(facultyDto.getEmail());
			faculty.setPasswordHash(passwordEncoder.encode(facultyDto.getPasswordHash()));
			faculty.setPhone(facultyDto.getPhone());
			faculty.setDesignation(facultyDto.getDesignation());
			faculty.setDepartment(facultyDto.getDepartment());
			
			faculty.setRole(Role.FACULTY);
			
			facultyRepository.save(faculty);
			
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(Map.of("message","Faculty Registration Successful!",
							"role",faculty.getRole()));
		}
		
	}
	
	// Login Faculty
	public ResponseEntity<ApiResponse<JwtLoginResponse>> loginFaculty(LoginRequest loginRequest){
		
		try {
			
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							  loginRequest.getEmail(),
							  loginRequest.getPassword()
							)
					);
			
			Faculty faculty = facultyRepository.findByEmail(loginRequest.getEmail())
					.orElseThrow(() -> new RuntimeException("Faculty not found!"));
			
			FacultyUserDetails userDetails = new FacultyUserDetails(faculty);
			
			String token = jwtUtil.createToken(userDetails.getUsername());

            JwtLoginResponse jwtResponse = new JwtLoginResponse();
            jwtResponse.setToken(token);
            jwtResponse.setUsername(faculty.getEmail());
            jwtResponse.setRole(faculty.getRole());

            return ResponseEntity.ok(
                    new ApiResponse<>(
                            true,
                            "Login successful!",
                            jwtResponse
                    )
            );
            
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
