package com.college.student.portal.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.college.student.portal.entity.Admin;
import com.college.student.portal.entity.Faculty;
import com.college.student.portal.entity.Student;
import com.college.student.portal.repository.AdminRepository;
import com.college.student.portal.repository.FacultyRepository;
import com.college.student.portal.repository.StudentRepository;

@Component
public class SecurityUserAuthenticationService implements UserDetailsService {

	private final StudentRepository studentRepository;
	private final FacultyRepository facultyRepository;
	private final AdminRepository adminRepository;
	
	public SecurityUserAuthenticationService(StudentRepository studentRepository, FacultyRepository facultyRepository,
			AdminRepository adminRepository) {
		super();
		this.studentRepository = studentRepository;
		this.facultyRepository = facultyRepository;
		this.adminRepository = adminRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		// 1️ Check Student
        Student student = studentRepository.findByEmail(email).orElse(null);
        if (student != null) {
            return new StudentUserDetails(student);
        }

        // 2️ Check Faculty
        Faculty faculty = facultyRepository.findByEmail(email).orElse(null);
        if (faculty != null) {
            return new FacultyUserDetails(faculty);
        };

        // 3️ Check Admin
        Admin admin = adminRepository.findByEmail(email).orElse(null);
        if (admin != null) {
            return new AdminUserDetails(admin);
        }

        throw new UsernameNotFoundException("User not found with email: " + email);
	}
}
