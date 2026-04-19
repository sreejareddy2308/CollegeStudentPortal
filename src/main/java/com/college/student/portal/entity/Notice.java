package com.college.student.portal.entity;

import java.time.LocalDate;

import com.college.student.portal.enums.TargetAudience;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notice {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	private String content;
	
	@Enumerated(EnumType.STRING)
	private TargetAudience target;
	
	private LocalDate postedDate;
	private LocalDate expiryDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="posted_by")
	private Admin admin;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setTarget(Object target2) {
		// TODO Auto-generated method stub
		
	}

	public void setAdmin(Admin admin2) {
		// TODO Auto-generated method stub
		
	}
}
