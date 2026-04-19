package com.college.student.portal.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentMonthlyAttendanceDTO {

	private String rollNumber;
    private String studentName;
    private List<DayAttendanceDTO> attendance;
	public StudentMonthlyAttendanceDTO(String rollNumber2, String name, List<DayAttendanceDTO> days) {
		// TODO Auto-generated constructor stub
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public List<DayAttendanceDTO> getAttendance() {
		return attendance;
	}
	public void setAttendance(List<DayAttendanceDTO> attendance) {
		this.attendance = attendance;
	}
}
