package com.college.student.portal.repository;

import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.student.portal.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	Optional<Student> findByEmail(String email);
	
	Optional<Student> findByRollNumber(String rollNumber);
	
	List<Student> findByBranchAndSemester(String branch, String semester);
	
	List<Student> findBySemester(String semester);

	Optional<Student> findByEmail(@Nullable Object email);
}
