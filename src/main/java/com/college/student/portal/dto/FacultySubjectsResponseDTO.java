package com.college.student.portal.dto;

public class FacultySubjectsResponseDTO {
	
	private String code;
	private String name;
	private String semester;
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSemester() {
		return semester;
	}
	
	public void setSemester(String semester) {
		this.semester = semester;
	}

	public FacultySubjectsResponseDTO(String code, String name, String semester) {
		super();
		this.code = code;
		this.name = name;
		this.semester = semester;
	}

	public FacultySubjectsResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FacultySubjectsResponseDTO [code=" + code + ", name=" + name + ", semester=" + semester + "]";
	}
	
	
	
	
	
}
