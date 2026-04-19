package com.college.student.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {

    private Integer studentId;
	private String rollNumber;
	private String name;
	private String email;
	private String phone;
	private int enrollYear;
	private String semester;
	private String branch;
	private String address;
	public StudentResponseDTO(Integer studentId2, String rollNumber2, String name2, String email2, String phone2,
			int enrollYear2, String semester2, String branch2, String address2) {
		// TODO Auto-generated constructor stub
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getEnrollYear() {
		return enrollYear;
	}
	public void setEnrollYear(int enrollYear) {
		this.enrollYear = enrollYear;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
