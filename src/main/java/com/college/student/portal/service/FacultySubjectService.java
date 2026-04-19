package com.college.student.portal.service;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.FacultySubjectDTO;
import com.college.student.portal.dto.FacultySubjectsResponseDTO;
import com.college.student.portal.entity.FacultyProfessional;
import com.college.student.portal.entity.FacultySubject;
import com.college.student.portal.entity.Subject;
import com.college.student.portal.repository.FacultyProfessionalRepository;
import com.college.student.portal.repository.FacultyRepository;
import com.college.student.portal.repository.FacultySubjectRepository;
import com.college.student.portal.repository.SubjectRepository;

@Service
public class FacultySubjectService {

	private final FacultySubjectRepository facultySubjectRepository;
	private final FacultyProfessionalRepository facultyProfessionalRepository;
	private final SubjectRepository subjectRepository;
	private final FacultyRepository facultyRepository;
	
	
	public FacultySubjectService(FacultySubjectRepository facultySubjectRepository,
			FacultyProfessionalRepository facultyProfessionalRepository, SubjectRepository subjectRepository,
			FacultyRepository facultyRepository) {
		super();
		this.facultySubjectRepository = facultySubjectRepository;
		this.facultyProfessionalRepository = facultyProfessionalRepository;
		this.subjectRepository = subjectRepository;
		this.facultyRepository = facultyRepository;
	}

	// Assign Subject to Faculty
	public ResponseEntity<Map<String, Object>> assignSubject(FacultySubjectDTO dto) {

	    FacultyProfessional faculty = facultyProfessionalRepository
	            .findById(dto.getFacultyId())
	            .orElseThrow(() -> new RuntimeException("Faculty not found"));

	    Subject subject = subjectRepository
	            .findById(dto.getSubjectId())
	            .orElseThrow(() -> new RuntimeException("Subject not found"));

	    boolean exists = facultySubjectRepository
	            .existsByFacultyProfessionalAndSubjectAndAcademicYear(
	                    faculty, subject, dto.getAcademicYear());

	    if (exists) {
	        return ResponseEntity.status(HttpStatus.CONFLICT)
	                .body(Map.of("message", "Subject already assigned for this academic year"));
	    }

	    FacultySubject fs = new FacultySubject();
	    fs.setFacultyProfessional(faculty);
	    fs.setSubject(subject);
	    fs.setAcademicYear(dto.getAcademicYear());

	    facultySubjectRepository.save(fs);

	    return ResponseEntity.status(HttpStatus.CREATED)
	            .body(Map.of(
	                    "message", "Subject assigned successfully",
	                    "id", fs.getId()
	            ));
	}
	
	// Fetch Subject Details by Faculty Id
	public java.util.List<FacultySubjectsResponseDTO> getSubjectsByFacultyId(Integer facultyId) {

	    if (!facultyRepository.existsById(facultyId)) {
	        throw new RuntimeException("FacultyId not found!");
	    }

	    return facultySubjectRepository.findSubjectsByFacultyId(facultyId);
	}


}
