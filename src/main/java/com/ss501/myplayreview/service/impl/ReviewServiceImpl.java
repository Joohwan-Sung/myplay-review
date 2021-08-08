package com.ss501.myplayreview.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ss501.myplayreview.domain.review.entity.Qna;
import com.ss501.myplayreview.domain.review.entity.Review;
import com.ss501.myplayreview.domain.review.repository.QnaRepository;
import com.ss501.myplayreview.domain.review.repository.ReviewRepository;
import com.ss501.myplayreview.service.ReviewService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
	private final ReviewRepository reviewRepository;
	private final QnaRepository qnaRepository;
	
	@Override
	public List<Review> findReviewsByPlaygroundId(Long playgroundId) {
		return reviewRepository.findAllReviewsByPlaygroundId(playgroundId);
	}

	@Override
	public List<Review> findAllReviews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review findReviewByReviewId(Long reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review saveReview(Review review) {
		// TODO Auto-generated method stub
		Review newReview = reviewRepository.save(review);
		return newReview;
	}

	
//	@Override
//	public List<Qna> findQnaByMemberId(String memberId) {
//		return qnaRepository.findQnaByMemberId(memberId);
//	}

	@Override
	public List<Qna> findAllQnas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Qna findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Qna> aQna = qnaRepository.findById(id);
		return aQna.get();
	}
	
	@Override
	public Qna saveQna(Qna qna) {
		// TODO Auto-generated method stub
		Qna newQna = qnaRepository.save(qna);		
		return newQna;
	}

	@Override
	public List<Qna> findQnaByPlaygroundId(List<Long> playgroundId) {
		// TODO Auto-generated method stub
		//return qnaRepository.findQnaByPlayground_PlaygroundId(playgroundId);
		return qnaRepository.findQnaByPlayground_PlaygroundIdIn(playgroundId);
		//return qnaRepository.findQna(playgroundId);
	}

	@Override
	public List<Qna> findQnaByQuestionerId(String questionerId) {
		// TODO Auto-generated method stub
		// return qnaRepository.findQnaByQuestionerId(questionerId);
		return qnaRepository.findQnaByQuestioner_QuestionerId(questionerId);
	}

	@Override
	public List<Qna> findQnaByAnswererId(String answererId) {
		// TODO Auto-generated method stub
		return qnaRepository.findQnaByAnswerer_AnswererId(answererId);
	}

	@Override
	public Qna updateQna(Long id, Qna qna) {
		// TODO Auto-generated method stub
		return qnaRepository.save(qna);
	}

}