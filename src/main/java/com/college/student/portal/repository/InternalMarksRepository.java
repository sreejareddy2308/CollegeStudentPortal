package com.college.student.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.student.portal.entity.Course;
import com.college.student.portal.entity.InternalMarks;
import com.college.student.portal.entity.Student;

@Repository
public interface InternalMarksRepository extends JpaRepository<InternalMarks, Integer>{
	Optional<InternalMarks> findByStudent_StudentIdAndCourse_Id(Integer studentId, Integer courseId);
	
	Optional<InternalMarks> findByStudentAndCourse(Student student, Course course);

	Optional<InternalMarks> findByStudent_StudentIdAndCourse_Id(Integer studentId, Object id);
}
