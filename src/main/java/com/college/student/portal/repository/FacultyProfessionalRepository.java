package com.college.student.portal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.student.portal.entity.Course;
import com.college.student.portal.entity.Faculty;
import com.college.student.portal.entity.FacultyProfessional;

@Repository
public interface FacultyProfessionalRepository extends JpaRepository<FacultyProfessional, Integer>{

	Optional<FacultyProfessional> findByFaculty(Faculty faculty);
	
	Optional<FacultyProfessional> findByEmployeeId(String employeeId);
	
	List<FacultyProfessional> findByDepartment(String department);

	Optional<Course> findAllById(String facultyProfessionalId);
}
