package com.college.student.portal.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacultySubjectDTO {

		private Integer id;

	    @NotNull(message = "Academic year is required")
	    @Positive(message = "Academic year must be a positive number")
	    private Long academicYear;

	    @NotNull(message = "Faculty id is required")
	    @Positive(message = "Faculty id must be a positive number")
	    private Integer facultyId;

	    @NotNull(message = "Subject id is required")
	    @Positive(message = "Subject id must be a positive number")
	    private Integer subjectId;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getFacultyId() {
			// TODO Auto-generated method stub
			return null;
		}

		public Integer getSubjectId() {
			// TODO Auto-generated method stub
			return null;
		}

		public Long getAcademicYear() {
			// TODO Auto-generated method stub
			return null;
		}
}
