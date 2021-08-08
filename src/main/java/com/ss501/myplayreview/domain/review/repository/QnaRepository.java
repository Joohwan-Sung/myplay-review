package com.ss501.myplayreview.domain.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ss501.myplayreview.domain.review.entity.Qna;

public interface QnaRepository extends JpaRepository<Qna, Long> {

	//List<Qna> findQnaByPlaygroundId(Long playgroundId);
	//List<Qna> findQnaByQuestionerId(String questionerId);
//	@Query(value = "select q from qna q where q.playgroundId = :playgroundIds")
//	List<Qna> findQnaByPlayground_PlaygroundId(List<Long> playgroundIds);
	List<Qna> findQnaByPlayground_PlaygroundIdIn(List<Long> playgroundId);
	List<Qna> findQnaByQuestioner_QuestionerId(String questionerId);
	List<Qna> findQnaByAnswerer_AnswererId(String answererId);
}
