package com.college.student.portal.repository;

import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.student.portal.entity.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer>{
	
	Optional<Faculty> findByEmail(String email);

	Optional<Faculty> findByEmail(@Nullable Object email);
}
