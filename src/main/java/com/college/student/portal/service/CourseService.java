package com.college.student.portal.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.CourseDTO;
import com.college.student.portal.entity.Course;
import com.college.student.portal.entity.FacultyProfessional;
import com.college.student.portal.repository.CourseRepository;
import com.college.student.portal.repository.FacultyProfessionalRepository;

@Service
public class CourseService {

	private final CourseRepository courseRepository;
	private final FacultyProfessionalRepository facultyProfessionalRepository;
	
	public CourseService(CourseRepository courseRepository,
			FacultyProfessionalRepository facultyProfessionalRepository) {
		super();
		this.courseRepository = courseRepository;
		this.facultyProfessionalRepository = facultyProfessionalRepository;
	}

	// Create Course
	public ResponseEntity<Map<String, Object>> createCourse(CourseDTO courseDto){
		
	System.out.println("Faculty ID = " + courseDto.getFacultyProfessionalId());
		
	FacultyProfessional facultyProfessional = facultyProfessionalRepository.findById(courseDto.getFacultyProfessionalId())
			.orElseThrow(() -> new RuntimeException("Professional Fcaulty not found!"));
	
	Optional<Course> existingCourse = courseRepository.findByCode(courseDto.getCode());
	
	if(existingCourse.isPresent()) {
		
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(Map.of("message","Course already exists!"));
		
	}else {
		
		Course course = new Course();
		
		course.setCode(courseDto.getCode());
		course.setName(courseDto.getName());
		course.setSemester(courseDto.getSemester());
		course.setCredits(courseDto.getCredits());
		course.setDepartment(courseDto.getDepartment());
		course.setAcademicYear(courseDto.getAcademicYear());
		course.setStartDate(courseDto.getStartDate());
		course.setEndDate(courseDto.getEndDate());
		
		System.out.println("Faculty ID = " + courseDto.getFacultyProfessionalId());

		
		course.setFacultyProfessional(facultyProfessional);
		
		courseRepository.save(course);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(Map.of("message","Course created Successfully!",
						"courseCode", courseDto.getCode()));
	}
	
	}
}
