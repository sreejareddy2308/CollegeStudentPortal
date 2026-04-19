package com.college.student.portal.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.student.portal.entity.Notice;
import com.college.student.portal.enums.TargetAudience;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer>{

	boolean existsByTitleAndTargetAndPostedDate(
		    String title,
		    TargetAudience target,
		    LocalDate postedDate
		);
	
	List<Notice> findByTarget(TargetAudience target);

	boolean existsByTitleAndTargetAndPostedDate(String title, Object target, LocalDate now);
}
