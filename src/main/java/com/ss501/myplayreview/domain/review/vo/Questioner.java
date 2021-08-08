package com.ss501.myplayreview.domain.review.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Questioner {
	@Column(name = "questionerId")
	private String questionerId;
	
	@Column(name = "questionerName")
	private String questionerName;
}
