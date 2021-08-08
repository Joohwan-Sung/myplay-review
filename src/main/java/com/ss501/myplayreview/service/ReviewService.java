package com.ss501.myplayreview.service;

import java.util.List;

import com.ss501.myplayreview.domain.review.entity.Qna;
import com.ss501.myplayreview.domain.review.entity.Review;

public interface ReviewService {
	List<Review> findAllReviews();
	List<Review> findReviewsByPlaygroundId(Long playgroundId);
	Review findReviewByReviewId(Long reviewId);
	Review saveReview(Review review);
	
	List<Qna> findQnaByPlaygroundId(List<Long> playgroundId);
	List<Qna> findQnaByQuestionerId(String questionerId);
	List<Qna> findQnaByAnswererId(String answererId);
	List<Qna> findAllQnas();
	Qna saveQna(Qna qna);
	Qna updateQna(Long id, Qna qna);
	Qna findById(Long id);
}
