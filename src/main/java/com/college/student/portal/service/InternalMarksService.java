package com.college.student.portal.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.InternalMarksDTO;
import com.college.student.portal.entity.Course;
import com.college.student.portal.entity.InternalMarks;
import com.college.student.portal.entity.Student;
import com.college.student.portal.repository.CourseRepository;
import com.college.student.portal.repository.InternalMarksRepository;
import com.college.student.portal.repository.StudentRepository;

@Service
public class InternalMarksService {

	private final InternalMarksRepository internalMarksRepository;
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	
	public InternalMarksService(InternalMarksRepository internalMarksRepository, StudentRepository studentRepository,
			CourseRepository courseRepository) {
		super();
		this.internalMarksRepository = internalMarksRepository;
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}
	
	// Enter Internal Marks
	public ResponseEntity<Map<String, Object>> enterInternalMarks(
	        InternalMarksDTO internalMarksDto,
	        String studentRoll,
	        Integer courseId
	) {

	    Student student = studentRepository.findByRollNumber(studentRoll)
	            .orElseThrow(() -> new RuntimeException("Student not found!"));

	    Course course = courseRepository.findById(courseId)
	            .orElseThrow(() -> new RuntimeException("Course not found!"));

	    Optional<InternalMarks> existingInternalMarks =
	            internalMarksRepository.findByStudentAndCourse(student, course);

	    if (existingInternalMarks.isPresent()) {
	        return ResponseEntity.status(HttpStatus.CONFLICT)
	                .body(Map.of("message", "Internal Marks already entered for this student & course"));
	    }


	    InternalMarks internalMarks = new InternalMarks();
	    internalMarks.setStudent(student);
	    internalMarks.setCourse(course);

	    internalMarks.setQuiz1(internalMarksDto.getQuiz1());
	    internalMarks.setQuiz2(internalMarksDto.getQuiz2());
	    internalMarks.setAssignment1(internalMarksDto.getAssignment1());
	    internalMarks.setAssignment2(internalMarksDto.getAssignment2());
	    internalMarks.setMidSem(internalMarksDto.getMidSem());

	    int total =
	            Optional.ofNullable(internalMarks.getQuiz1()).orElse(0)
	          + Optional.ofNullable(internalMarks.getQuiz2()).orElse(0)
	          + Optional.ofNullable(internalMarks.getAssignment1()).orElse(0)
	          + Optional.ofNullable(internalMarks.getAssignment2()).orElse(0)
	          + Optional.ofNullable(internalMarks.getMidSem()).orElse(0);

	    internalMarks.setTotalInternal(total);

	    internalMarksRepository.save(internalMarks);

	    return ResponseEntity.status(HttpStatus.CREATED)
	            .body(Map.of("message", "Internal Marks entered Successfully!"));
	}

}
