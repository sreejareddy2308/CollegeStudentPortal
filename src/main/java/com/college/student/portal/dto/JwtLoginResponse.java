package com.college.student.portal.dto;


import com.college.student.portal.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtLoginResponse {
	
	@SuppressWarnings("unused")
	private String token;
	@SuppressWarnings("unused")
	private String username;
	private Role role;
	public void setUsername(String email) {
		// TODO Auto-generated method stub
		
	}
	public void setToken(String token2) {
		// TODO Auto-generated method stub
		
	}
	public void setRole(Object role2) {
		// TODO Auto-generated method stub
		
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
