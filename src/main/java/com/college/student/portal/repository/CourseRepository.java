package com.college.student.portal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.college.student.portal.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	Optional<Course> findByCode(String code);
	
	// Available courses for semester NOT enrolled by student
	@Query("""
			SELECT c FROM Course c
			WHERE c.semester = :semester
			AND c.academicYear = :academicYear
			AND NOT EXISTS (
			    SELECT 1 FROM Enrollment e
			    WHERE e.course = c
			    AND e.student.studentId = :studentId
			    AND e.status = 'ACTIVE'
			)
			""")
			List<Course> findAvailableCourses(
			    String semester,
			    int academicYear,
			    Integer studentId
			);


	List<Course> findBySemester(String semester);

}
