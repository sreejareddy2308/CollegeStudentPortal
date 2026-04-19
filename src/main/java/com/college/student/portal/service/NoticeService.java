package com.college.student.portal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.NoticeDTO;
import com.college.student.portal.dto.NoticeResponseDTO;
import com.college.student.portal.entity.Admin;
import com.college.student.portal.entity.Notice;
import com.college.student.portal.enums.TargetAudience;
import com.college.student.portal.repository.AdminRepository;
import com.college.student.portal.repository.NoticeRepository;

@Service
public class NoticeService {

	private final NoticeRepository noticeRepository;
	private final AdminRepository adminRepository;
	
	public NoticeService(NoticeRepository noticeRepository, AdminRepository adminRepository) {
		super();
		this.noticeRepository = noticeRepository;
		this.adminRepository = adminRepository;
	}
	
	// POST Notice
	public ResponseEntity<Map<String, Object>> postNotice(NoticeDTO noticeDto){
		
		Admin admin = adminRepository.findById(noticeDto.getAdminId())
				.orElseThrow(() -> new RuntimeException("Admin not found!"));
		
		if (noticeRepository.existsByTitleAndTargetAndPostedDate(
		        noticeDto.getTitle(),
		        noticeDto.getTarget(),
		        LocalDate.now())) {
		    throw new RuntimeException("Notice already posted today!");
		}

		Notice notice = new Notice();
		notice.setTitle(noticeDto.getTitle());
		notice.setContent(noticeDto.getContent());
		notice.setTarget(noticeDto.getTarget());
		notice.setPostedDate(LocalDate.now());
		notice.setExpiryDate(noticeDto.getExpiryDate());
		notice.setAdmin(admin);
		
		noticeRepository.save(notice);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(Map.of("message","Notice Created Successfully!"));
		
	}
	
	// GET notice by Target
	public List<NoticeResponseDTO> getNoticeByTarget(TargetAudience target) {

	    return noticeRepository.findByTarget(target)
	            .stream()
	            .map(notice -> new NoticeResponseDTO(
	                    notice.getTitle(),
	                    notice.getContent(),
	                    notice.getPostedDate(),
	                    notice.getExpiryDate()
	            ))
	            .toList();
	}

}
