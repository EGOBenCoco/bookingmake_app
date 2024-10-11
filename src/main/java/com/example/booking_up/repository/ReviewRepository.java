package com.example.booking_up.repository;

import com.example.booking_up.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByRatingOrderByRatingAsc(int id);
    List<Review> findByRatingOrderByRatingDesc(int id);
    List<Review> findAllById(int id);
}
