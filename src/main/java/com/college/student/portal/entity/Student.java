package com.college.student.portal.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.college.student.portal.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer studentId;
	
	private String rollNumber;
	private String name;
	private String email;
	private String phone;
	private String passwordHash;
	private int enrollYear;
	private String semester;
	private String branch;
	private String address;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Enumerated(EnumType.STRING)
	private Role role;

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

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
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

	public Integer getStudentId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRole() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCreatedAt(LocalDateTime createdAt2) {
		// TODO Auto-generated method stub
		
	}

	public void setRole(Role student) {
		// TODO Auto-generated method stub
		
	}
		
}
