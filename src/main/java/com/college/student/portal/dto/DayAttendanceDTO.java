package com.college.student.portal.dto;

import java.time.LocalDate;

import com.college.student.portal.enums.AttendanceStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DayAttendanceDTO {

	private LocalDate date;
    private AttendanceStatus status;
	public DayAttendanceDTO(LocalDate date2, Object status2) {
		// TODO Auto-generated constructor stub
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public AttendanceStatus getStatus() {
		return status;
	}
	public void setStatus(AttendanceStatus status) {
		this.status = status;
	}
}
