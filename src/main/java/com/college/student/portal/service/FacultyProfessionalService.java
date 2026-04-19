package com.college.student.portal.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.FacultyProfessionalDTO;
import com.college.student.portal.dto.FacultyProfessionalResponseDTO;
import com.college.student.portal.entity.Faculty;
import com.college.student.portal.entity.FacultyProfessional;
import com.college.student.portal.repository.FacultyProfessionalRepository;
import com.college.student.portal.repository.FacultyRepository;

@Service
public class FacultyProfessionalService {

	private final FacultyProfessionalRepository facultyProfessionalRepository;
    private final FacultyRepository facultyRepository;

    public FacultyProfessionalService(FacultyProfessionalRepository facultyProfessionalRepository,
                                      FacultyRepository facultyRepository) {
        this.facultyProfessionalRepository = facultyProfessionalRepository;
        this.facultyRepository = facultyRepository;
    }

    // Create Professional Faculty
    public ResponseEntity<Map<String, Object>> createFacultyProfessional(
            FacultyProfessionalDTO dto) {

        // Fetch Faculty Personal
        Faculty faculty = facultyRepository.findById(dto.getFacultyPersonalId())
                .orElseThrow(() -> new RuntimeException("Faculty personal not found"));

        // Check if Professional faculty already exists
        Optional<FacultyProfessional> existing =
                facultyProfessionalRepository.findByFaculty(faculty);

        if (existing.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("message", "Faculty professional already exists"));
        }

        //  Map DTO → Entity
        FacultyProfessional facultyProfessional = new FacultyProfessional();
        facultyProfessional.setEmployeeId(dto.getEmployeeId());
        facultyProfessional.setDesignation(dto.getDesignation());
        facultyProfessional.setDepartment(dto.getDepartment());
        facultyProfessional.setJoiningDate(dto.getJoiningDate());
        facultyProfessional.setSalary(dto.getSalary());
        facultyProfessional.setFaculty(faculty);

      
        facultyProfessionalRepository.save(facultyProfessional);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of(
                        "message", "Professional faculty created successfully",
                        "employeeId", facultyProfessional.getEmployeeId()
                ));
    }
    
    // Get Professional Faculty by Employee Id
    public FacultyProfessionalResponseDTO getFacultyProfessional(String employeeId) {

        FacultyProfessional fac = facultyProfessionalRepository
                .findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee Id not found: "+ employeeId));

        return new FacultyProfessionalResponseDTO(
                fac.getEmployeeId(),
                fac.getDesignation(),
                fac.getDepartment(),
                fac.getJoiningDate(),
                fac.getSalary()
        );
    }

    // Get Professional Faculty List by Department
    public List<FacultyProfessionalResponseDTO> getFacultyByDepartment(String department){
    	
    	List<FacultyProfessional> faculties = facultyProfessionalRepository.findByDepartment(department);
    	
    	return faculties.stream()
    			.map(facu -> new FacultyProfessionalResponseDTO (
    					facu.getEmployeeId(),
    					facu.getDesignation(),
    					facu.getDepartment(),
    					facu.getJoiningDate(),
    					facu.getSalary()
    					))
    			.toList();
    }
	
}
