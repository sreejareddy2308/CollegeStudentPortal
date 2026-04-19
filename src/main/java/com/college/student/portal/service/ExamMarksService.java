package com.college.student.portal.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.ExamMarksDTO;
import com.college.student.portal.entity.Course;
import com.college.student.portal.entity.ExamMarks;
import com.college.student.portal.entity.InternalMarks;
import com.college.student.portal.entity.Student;
import com.college.student.portal.repository.CourseRepository;
import com.college.student.portal.repository.ExamMarksRepository;
import com.college.student.portal.repository.InternalMarksRepository;
import com.college.student.portal.repository.StudentRepository;

@Service
public class ExamMarksService {

	private final ExamMarksRepository examMarksRepository;
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	private final InternalMarksRepository internalMarksRepository;
	
	public ExamMarksService(ExamMarksRepository examMarksRepository, StudentRepository studentRepository,
			CourseRepository courseRepository, InternalMarksRepository internalMarksRepository) {
		super();
		this.examMarksRepository = examMarksRepository;
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
		this.internalMarksRepository = internalMarksRepository;
	}

	// Enter Exam Marks
	public ResponseEntity<Map<String, Object>> enterExamMarks(
	        ExamMarksDTO examMarksDto,
	        String studentRoll,
	        Integer courseId) {

	    Student student = studentRepository.findByRollNumber(studentRoll)
	            .orElseThrow(() -> new RuntimeException("Student not found!"));

	    Course course = courseRepository.findById(courseId)
	            .orElseThrow(() -> new RuntimeException("Course not found!"));

	    Optional<ExamMarks> existingExamMarks =
	            examMarksRepository.findByStudentAndCourse(student, course);

	    if (existingExamMarks.isPresent()) {
	        return ResponseEntity.status(HttpStatus.CONFLICT)
	                .body(Map.of("message", "Exam marks already entered!"));
	    }
	    
	    InternalMarks internal = internalMarksRepository
	            .findByStudentAndCourse(student, course)
	            .orElseThrow(() -> new RuntimeException("Internal marks not found"));
	    
	    int total = internal.getTotalInternal() + examMarksDto.getEndSemMarks();

	    ExamMarks examMarks = new ExamMarks();
	    examMarks.setStudent(student);
	    examMarks.setCourse(course);
	    examMarks.setEndSemMarks(examMarksDto.getEndSemMarks());
	    examMarks.setTotalMarks(total);

	    examMarksRepository.save(examMarks);

	    return ResponseEntity.status(HttpStatus.CREATED)
	            .body(Map.of(
	                    "message", "Exam marks entered successfully",
	                    "studentRoll", studentRoll,
	                    "courseId", courseId,
	                    "endSemMarks", examMarksDto.getEndSemMarks(),
	                    "totalMarks", total
	            ));
	}

}
