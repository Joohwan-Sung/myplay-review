package com.ss501.myplayreview.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss501.myplayreview.domain.review.entity.Qna;
import com.ss501.myplayreview.domain.review.entity.Review;
import com.ss501.myplayreview.service.ReviewService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/review/api/v1")
@AllArgsConstructor
public class ReviewController {
	private final ReviewService reviewService;
	private static final Logger log = LoggerFactory.getLogger(ReviewController.class);

	@GetMapping("/reviews/{playgroundId}")
	public ResponseEntity<List<Review>> findReviewsByPlaygroundId(@PathVariable Long playgroundId) {
		log.info("ReviewController : ResponseEntity<List<Review>> findReviewsByPlaygroundId / "
				+ playgroundId.toString());
		return ResponseEntity.ok().body(reviewService.findReviewsByPlaygroundId(playgroundId));
	}

	@PostMapping("/review")
	public ResponseEntity<Review> saveReview(@RequestBody Review review) {
		log.info("Json : " + review.toString());
		Review newReview = reviewService.saveReview(review);
		log.info("newReview Json : " + newReview.toString());
		return ResponseEntity.ok().body(newReview);
	}

	
	@GetMapping("/qna/corp/{playgroundId}")
	public ResponseEntity<List<Qna>> findQnaByPlaygroundId(@PathVariable List<Long> playgroundId) { 
		log.info("ReviewController : ResponseEntity<List<Qna>> findQnaByPlaygroundId / " + playgroundId.toString());
//		List<Long> longList = new ArrayList<>();
//		for(int i=0; i<playgroundId.size(); i++) {
//			longList.add(Long.parseLong(playgroundId.get(0)));
//		}
//		return ResponseEntity.ok().body(reviewService.findQnaByPlaygroundId(longList));
		return ResponseEntity.ok().body(reviewService.findQnaByPlaygroundId(playgroundId));
	}
	 

	@GetMapping("/qna/{questionerId}")
	public ResponseEntity<List<Qna>> findQnaByQuestionerId(@PathVariable String questionerId) {
		log.info("ReviewController : ResponseEntity<List<Qna>> findQnaByQuestionerId / " + questionerId.toString());
		return ResponseEntity.ok().body(reviewService.findQnaByQuestionerId(questionerId));
	}

//	@GetMapping("/qna/corp/{answererId}")
//	public ResponseEntity<List<Qna>> findQnaByAnswererId(@PathVariable String answererId) {
//		log.info("ReviewController : ResponseEntity<List<Qna>> findQnaByAnswererId / " + answererId.toString());
//		return ResponseEntity.ok().body(reviewService.findQnaByAnswererId(answererId));
//	}

	@PostMapping("/qna")
	public ResponseEntity<Qna> saveQna(@RequestBody Qna qna) {
		log.info("Json : " + qna.toString());
		Qna newQna = reviewService.saveQna(qna);
		log.info("newReview Json : " + newQna.toString());
		return ResponseEntity.ok().body(newQna);
	}
	
	@PutMapping("/qna/{qnaId}")
	public ResponseEntity<Qna> saveAnswer(@RequestBody Qna qna, @PathVariable Long qnaId) {
		log.info("Json : " + qna.toString());
		log.info("qnaId : " + qnaId.toString());
		log.info("reviewService.findByIdQna(qnaId) >> " + reviewService.findById(qnaId));
		Optional<Qna> oldQna = Optional.of(reviewService.findById(qnaId));
		
        if (oldQna.get() == null) {
            log.error("qna with id " + qnaId + " not found");
            return new ResponseEntity<Qna>(HttpStatus.NO_CONTENT);
        }
        
        Qna modifyingQna = oldQna.get();
        modifyingQna.setAnswer(qna.getAnswer());
        modifyingQna.setAnswerer(qna.getAnswerer());
        modifyingQna.setCreateDateA(qna.getCreateDateA());
        //modifyingQna.setId(qnaId);
        
		Qna newQna = reviewService.updateQna(qnaId, modifyingQna);
		log.info("newReview Json : " + newQna.toString());
		return ResponseEntity.ok().body(newQna);
	}
}
