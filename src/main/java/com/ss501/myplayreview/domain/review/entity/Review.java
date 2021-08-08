package com.ss501.myplayreview.domain.review.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.ss501.myplayreview.domain.review.enums.ReviewStatus;
import com.ss501.myplayreview.domain.review.vo.PersonalMember;
import com.ss501.myplayreview.domain.review.vo.Playground;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 					// getter/setter 생성
@AllArgsConstructor		// 생성자 생성
@NoArgsConstructor		// 생성자 생성
@Entity
@Table(name = "Review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Embedded
	@Column(name="writer")
	private PersonalMember writer;
	
//	@Embedded
//	@Column(name = "playgroud")
//	private Playground playgroud;
	@Column(name = "playgroundId")
	private Long playgroundId;
	
	@Column(name = "contents")
	private String contents;
	
	@Column(name = "createDate")
	private String createDate;
	
	@Column(name = "mark")
	private Integer mark;
	
	@Column(name = "reviewStatus")
	@Enumerated(EnumType.STRING)
	private ReviewStatus reviewStatus;

}
