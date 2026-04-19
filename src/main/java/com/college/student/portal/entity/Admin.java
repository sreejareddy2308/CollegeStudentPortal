package com.college.student.portal.entity;

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
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String email;
	private String passwordHash;
	private String phone;
	
	@Enumerated(EnumType.STRING)
	private Role role;

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

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setRole(Role admin) {
		// TODO Auto-generated method stub
		
	}

	public Object getRole() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getRole13() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getRole12() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getRole11111() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getRole1() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getRole1111() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getRole111() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getRole11() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
