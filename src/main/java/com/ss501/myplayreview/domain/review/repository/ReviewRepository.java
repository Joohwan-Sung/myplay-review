package com.ss501.myplayreview.domain.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss501.myplayreview.domain.review.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	List<Review> findAllReviewsByPlaygroundId(Long playgroundId);
}
