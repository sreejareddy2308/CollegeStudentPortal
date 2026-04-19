package com.college.student.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.college.student.portal.dto.FacultySubjectsResponseDTO;
import com.college.student.portal.entity.FacultyProfessional;
import com.college.student.portal.entity.FacultySubject;
import com.college.student.portal.entity.Subject;

@Repository
public interface FacultySubjectRepository extends JpaRepository<FacultySubject, Integer>{

	boolean existsByFacultyProfessionalAndSubjectAndAcademicYear(
	        FacultyProfessional facultyProfessional,
	        Subject subject,
	        Long academicYear
	);

	/*
	SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END
	FROM faculty_subject
	WHERE faculty_id = ? AND subject_id = ? AND academic_year = ? */
	
	@Query("""
	        SELECT new com.college.student.portal.dto.FacultySubjectsResponseDTO(
	            s.code,
	            s.name,
	            s.semester
	        )
	        FROM FacultySubject fs
	        JOIN fs.subject s
	        WHERE fs.facultyProfessional.id = :facultyId
	    """)
	List<FacultySubjectsResponseDTO> findSubjectsByFacultyId(
            @Param("facultyId") Integer facultyId
    );

}
