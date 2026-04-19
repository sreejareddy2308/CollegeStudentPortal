package com.college.student.portal.util;

public class GradeUtil {
	
	public static String calculateGrade(Integer totalMarks) {

        if (totalMarks == null) return "NA";

        if (totalMarks >= 85) return "O";
        if (totalMarks >= 70) return "A";
        if (totalMarks >= 60) return "B";
        if (totalMarks >= 45) return "C";
        if (totalMarks >= 35) return "D";
        return "F";
    }

}
