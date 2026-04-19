package com.college.student.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.student.portal.entity.Course;
import com.college.student.portal.entity.ExamMarks;
import com.college.student.portal.entity.Student;

@Repository
public interface ExamMarksRepository extends JpaRepository<ExamMarks, Integer>{

	Optional<ExamMarks> findByStudent_StudentIdAndCourse_Id(Integer studentId, Integer courseId);
	
	Optional<ExamMarks> findByStudentAndCourse(Student student, Course course);

	Optional<ExamMarks> findByStudent_StudentIdAndCourse_Id(Integer studentId, Object id);
}
