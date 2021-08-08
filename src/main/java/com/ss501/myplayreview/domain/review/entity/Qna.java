package com.ss501.myplayreview.domain.review.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ss501.myplayreview.domain.review.vo.Answerer;
import com.ss501.myplayreview.domain.review.vo.Playground;
import com.ss501.myplayreview.domain.review.vo.Questioner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 					// getter/setter 생성
@AllArgsConstructor		// 생성자 생성
@NoArgsConstructor		// 생성자 생성
@Entity
@Table(name = "Qna")
public class Qna {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
//	@Column(name = "parentQnaId")
//	private Long parentQnaId;

//	@Column(name="questionerId")
//	private String questionerId;
//	
//	@Column(name="questionerName")
//	private String questionerName;
//
//	@Column(name="answererId")
//	private String answererId;
//	
//	@Column(name="answererName")
//	private String answererName;
	
//	@Column(name="playgroundId")
//	private Long playgroundId;
//	
//	@Column(name="playgroundName")
//	private String playgroundName;
		
	@Column(name = "question")
	private String question;
	
	@Column(name = "answer")
	private String answer;
	
	@Column(name = "createDateQ")
	private String createDateQ;
	
	@Column(name = "createDateA")
	private String createDateA;
	
	@Embedded
	@Column(name="questioner")
	private Questioner questioner;
	
	@Embedded
	@Column(name="playground")
	private Playground playground;
	
	@Embedded
	@Column(name="answerer")
	private Answerer answerer;
	
//	
//	@Embedded
//	@Column(name="createUser")
//	private CreateUser createUser;
	
	
//	@Column(name = "contents")
//	private String contents;
//	
//	@Column(name = "createDate")
//	private String createDate;
//	
//	@Embedded
//	@Column(name="createUser")
//	private CreateUser createUser;
}
