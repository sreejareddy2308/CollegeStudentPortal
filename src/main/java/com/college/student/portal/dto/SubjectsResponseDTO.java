package com.college.student.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectsResponseDTO {

	public SubjectsResponseDTO(Object code2, Object name2, Object credits2, Object semester2, Object department2) {
	}
	
	public String code;
	public String name;
	public int credits;
	public String semester;
	public String department;
}
