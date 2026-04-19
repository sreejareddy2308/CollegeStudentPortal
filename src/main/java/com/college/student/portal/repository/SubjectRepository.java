package com.college.student.portal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.student.portal.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{
	
	Optional<Subject> findByCode(String code);
	
	List<Subject> findByDepartmentAndSemester(String department, String semester);
}
