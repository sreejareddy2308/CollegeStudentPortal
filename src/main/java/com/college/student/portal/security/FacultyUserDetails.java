package com.college.student.portal.security;

import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.college.student.portal.entity.Faculty;

public class FacultyUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Faculty faculty;
	
	public FacultyUserDetails(Faculty faculty) {
		super();
		this.faculty = faculty;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(
	            new SimpleGrantedAuthority("ROLE_" + faculty.getRole())
	        );
	}

	@Override
	public @Nullable String getPassword() {
		return faculty.getPasswordHash();
	}

	@Override
	public String getUsername() {
		return faculty.getEmail();
	}
	
	@Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Integer getId() {
        return faculty.getId();
    }
}
