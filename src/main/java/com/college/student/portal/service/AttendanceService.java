package com.college.student.portal.service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.AttendanceDTO;
import com.college.student.portal.dto.DayAttendanceDTO;
import com.college.student.portal.dto.StudentMonthlyAttendanceDTO;
import com.college.student.portal.entity.Attendance;
import com.college.student.portal.entity.Course;
import com.college.student.portal.entity.FacultyProfessional;
import com.college.student.portal.entity.Student;
import com.college.student.portal.repository.AttendanceRepository;
import com.college.student.portal.repository.CourseRepository;
import com.college.student.portal.repository.FacultyProfessionalRepository;
import com.college.student.portal.repository.StudentRepository;

@Service
public class AttendanceService {

	private final AttendanceRepository attendanceRepository; 
	private final StudentRepository studentRepository;
	private final FacultyProfessionalRepository facultyProfessionalRepository;
	private final CourseRepository courseRepository;
	
	public AttendanceService(AttendanceRepository attendanceRepository, StudentRepository studentRepository,
			FacultyProfessionalRepository facultyProfessionalRepository, CourseRepository courseRepository) {
		super();
		this.attendanceRepository = attendanceRepository;
		this.studentRepository = studentRepository;
		this.facultyProfessionalRepository = facultyProfessionalRepository;
		this.courseRepository = courseRepository;
	}

	// Mark Attendance
	public ResponseEntity<Map<String, Object>> markAttendance(
	        AttendanceDTO attendanceDto,
	        Integer facultyId,
	        Integer courseId) {

	    Student student = studentRepository.findById(attendanceDto.getStudentId())
	            .orElseThrow(() -> new RuntimeException("Student not found!"));

	    FacultyProfessional facultyProfessional = facultyProfessionalRepository.findById(facultyId)
	            .orElseThrow(() -> new RuntimeException("Faculty not found!"));

	    Course course = courseRepository.findById(courseId)
	            .orElseThrow(() -> new RuntimeException("Course not found!"));

	    Optional<Attendance> existingAttendance =
	            attendanceRepository.findByStudentAndDateAndCourse(
	                    student,
	                    attendanceDto.getDate(),
	                    course
	            );

	    if (existingAttendance.isPresent()) {
	        return ResponseEntity.status(HttpStatus.CONFLICT)
	                .body(Map.of("message", "Attendance already marked!"));
	    }

	    Attendance attendance = new Attendance();
	    attendance.setDate(attendanceDto.getDate());
	    attendance.setStatus(attendanceDto.getStatus());
	    attendance.setStudent(student);
	    attendance.setFacultyProfessional(facultyProfessional);
	    attendance.setCourse(course);

	    attendanceRepository.save(attendance);

	    return ResponseEntity.status(HttpStatus.CREATED)
	            .body(Map.of("message", "Attendance Marked Successfully!"));
	}
	
	// View Attendance
	public List<StudentMonthlyAttendanceDTO> getMonthlyAttendance(
	        String courseCode,
	        String month) {

	    // Parse month (2026-01)
	    YearMonth yearMonth = YearMonth.parse(month);
	    LocalDate startDate = yearMonth.atDay(1);
	    LocalDate endDate = yearMonth.atEndOfMonth();

	    // Fetch course
	    Course course = courseRepository.findByCode(courseCode)
	            .orElseThrow(() -> new RuntimeException("Course not found"));

	    // Fetch attendance records
	    List<Attendance> records =
	            attendanceRepository.findByCourseAndDateBetween(
	                    course, startDate, endDate);

	    // Group by student
	    Map<Student, List<Attendance>> grouped = records.stream()
	    		.collect(Collectors.groupingBy(Attendance::getStudent));

	    // Map to DTOs
	    List<StudentMonthlyAttendanceDTO> response = new ArrayList<>();

	    for (Map.Entry<Student, List<Attendance>> entry : grouped.entrySet()) {
	        Student student = entry.getKey();

	        List<DayAttendanceDTO> days = entry.getValue().stream()
	                .map(a -> new DayAttendanceDTO(a.getDate(), a.getStatus()))
	                .sorted(Comparator.comparing(DayAttendanceDTO::getDate))
	                .toList();

	        response.add(new StudentMonthlyAttendanceDTO(
	                student.getRollNumber(),
	                student.getName(),
	                days
	        ));
	    }

	    return response;
	}
}
