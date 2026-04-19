package com.college.student.portal.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.AvailableCoursesResponseDTO;
import com.college.student.portal.dto.CourseStudentDTO;
import com.college.student.portal.dto.CourseStudentsResponseDTO;
import com.college.student.portal.dto.EnrolledCoursesResponseDTO;
import com.college.student.portal.dto.EnrollmentDTO;
import com.college.student.portal.entity.Course;
import com.college.student.portal.entity.Enrollment;
import com.college.student.portal.entity.Student;
import com.college.student.portal.enums.EnrollmentStatus;
import com.college.student.portal.repository.CourseRepository;
import com.college.student.portal.repository.EnrollmentRepository;
import com.college.student.portal.repository.StudentRepository;

@Service
public class EnrollmentService {

	private final EnrollmentRepository enrollmentRepository;
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	
	public EnrollmentService(EnrollmentRepository enrollmentRepository, StudentRepository studentRepository,
			CourseRepository courseRepository) {
		super();
		this.enrollmentRepository = enrollmentRepository;
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}
	
	// Enroll Student for Course
	public ResponseEntity<Map<String, Object>> enrollStudent(
	        String roll,
	        EnrollmentDTO enrollmentDto) {

	    // check student (USE roll from URL)
	    Student student = studentRepository.findByRollNumber(roll)
	            .orElseThrow(() -> new RuntimeException("Student not found!"));

	    // check course (no change)
	    Course course = courseRepository.findById(enrollmentDto.getCourseId())
	            .orElseThrow(() -> new RuntimeException("Course not found!"));

	    // check existing enrollment
	    Optional<Enrollment> existingEnrollment =
	            enrollmentRepository
	                    .findByStudent_RollNumberAndCourse_Id(
	                            roll,                      
	                            enrollmentDto.getCourseId()
	                    );

	    // check semester matches or not
	    if (!student.getSemester().equals(course.getSemester())) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(Map.of("message", "Semester mismatch!"));
	    }

	    if (existingEnrollment.isPresent()) {

	        return ResponseEntity.status(HttpStatus.CONFLICT)
	                .body(Map.of("message", "Student already enrolled for this course!"));

	    } else {

	        Enrollment enrollment = new Enrollment();
	        enrollment.setEnrollDate(LocalDate.now());
	        enrollment.setStatus(EnrollmentStatus.ACTIVE);
	        enrollment.setStudent(student);
	        enrollment.setCourse(course);

	        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);

	        return ResponseEntity.status(HttpStatus.CREATED)
	                .body(Map.of(
	                        "message", "Enrolled Successfully!",
	                        "enrollmentId", savedEnrollment.getId()   // ← FIXED
	                ));
	    }
	}
	
	// Fetch Student Courses (Enrolled + Available Courses)
	public Map<String, Object> getStudentCourses(String roll) {

	    Student student = studentRepository.findByRollNumber(roll)
	        .orElseThrow(() -> new RuntimeException("Student not found"));

	    Integer studentId = student.getStudentId();

	    // 1. Enrolled courses (ENTITY)
	    List<Enrollment> enrolled =
	        enrollmentRepository.findByStudent_StudentIdAndStatus(
	            studentId, EnrollmentStatus.ACTIVE
	        );

	    // 2. Available courses (ENTITY)
	    List<Course> available =
	        courseRepository.findAvailableCourses(
	            student.getSemester(),
	            student.getEnrollYear(),
	            studentId
	        );

	    // Convert enrolled → DTO
	    List<EnrolledCoursesResponseDTO> enrolledDto = enrolled.stream()
	        .map(e -> new EnrolledCoursesResponseDTO(
	            e.getCourse().getId(),
	            e.getCourse().getCode(),
	            e.getCourse().getName(),
	            e.getCourse().getSemester(),
	            e.getCourse().getCredits(),
	            e.getStatus()
	        ))
	        .toList();

	    // Convert available → DTO
	    List<AvailableCoursesResponseDTO> availableDto = available.stream()
	        .map(c -> new AvailableCoursesResponseDTO(
	            c.getId(),
	            c.getCode(),
	            c.getName(),
	            c.getSemester(),
	            c.getCredits()
	        ))
	        .toList();

	    Map<String, Object> response = new HashMap<>();
	    response.put("enrolledCourses", enrolledDto);
	    response.put("availableCourses", availableDto);

	    return response;
	}
	
	// Fetch Students by Course Code
	public CourseStudentsResponseDTO getStudentsByCourseCode(String code) {

	    Course course = courseRepository.findByCode(code)
	        .orElseThrow(() -> new RuntimeException("Course not found"));

	    List<Enrollment> enrollments =
	        enrollmentRepository.findByCourse_Code(code);

	    List<CourseStudentDTO> students = enrollments.stream()
	        .map(e -> new CourseStudentDTO(
	            e.getStudent().getRollNumber(),
	            e.getStudent().getName(),
	            e.getStudent().getEmail(),
	            e.getEnrollDate(),
	            e.getStatus()
	        ))
	        .toList();

	    return new CourseStudentsResponseDTO(
	        course.getCode(),
	        course.getName(),
	        students.size(),
	        students
	    );
	}
}
