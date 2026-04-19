package com.college.student.portal.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.SubjectDTO;
import com.college.student.portal.dto.SubjectsResponseDTO;
import com.college.student.portal.entity.Subject;
import com.college.student.portal.repository.SubjectRepository;

@Service
public class SubjectService {

	private final  SubjectRepository subjectRepository;

	public SubjectService(SubjectRepository subjectRepository) {
		super();
		this.subjectRepository = subjectRepository;
	}
	
	// Add Subject
	public ResponseEntity<Map<String, Object>> addSubject(SubjectDTO subjectDto){

	    Optional<Subject> isExistingSubject =
	            subjectRepository.findByCode(subjectDto.getCode());

	    if (isExistingSubject.isPresent()) {
	    	
	        return ResponseEntity.status(HttpStatus.CONFLICT)
	        		.body(Map.of("message", "Subject already exists with code: " + subjectDto.getCode()));

	    } else {

	        Subject subject = new Subject();
	        subject.setCode(subjectDto.getCode());
	        subject.setName(subjectDto.getName());
	        subject.setCredits(subjectDto.getCredits());
	        subject.setSemester(subjectDto.getSemester());
	        subject.setDepartment(subjectDto.getDepartment());

	        subjectRepository.save(subject);

	        return ResponseEntity.status(HttpStatus.CREATED)
	        		.body(Map.of("message","Subject added Successfully!"
	        				));
	    }
	}

	// Get Subjects by Department and Semester
	public List<SubjectsResponseDTO> getSubjectsByDepartmentAndSemester(String department, String semester){
		
		List<Subject> subjects = subjectRepository.findByDepartmentAndSemester(department, semester);
		
		return subjects.stream()
				.map(subject -> new SubjectsResponseDTO(
						subject.getCode(),
						subject.getName(),
						subject.getCredits(),
						subject.getSemester(),
						subject.getDepartment()
						))
				.toList();
	}
}
