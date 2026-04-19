package com.college.student.portal.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateDTO {

	@Pattern(
	        regexp = "^[6-9]\\d{9}$",
	        message = "Phone number must be a valid 10-digit Indian mobile number"
	    )
	    private String phone;

	    @Size(max = 500, message = "Address cannot exceed 500 characters")
	    private String address;

		public String getPhone() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getAddress() {
			// TODO Auto-generated method stub
			return null;
		}
}
