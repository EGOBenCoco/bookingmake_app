package com.example.booking_up.controller;

import com.example.booking_up.entity.Review;
import com.example.booking_up.service.ReviewService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReviewController {
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Review review) {
        reviewService.createReview(review);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Review>> findById(@PathVariable int id) {
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

/*    @GetMapping
    public ResponseEntity<List<Review>>findAllByMasterId(int id) {
        return ResponseEntity.ok(reviewService.getAllReviewsByMasterId(id));
    }

    @GetMapping
    public ResponseEntity<List<Review>>findAllByClientId(int id) {
        return ResponseEntity.ok(reviewService.getAllReviewsByClientId(id));
    }

    @GetMapping
    public ResponseEntity<List<Review>>findAllByMasterIdAsc(int id) {
        return ResponseEntity.ok(reviewService.getAllReviewsByMasterIdAsc(id));
    }

    @GetMapping
    public ResponseEntity<List<Review>>findAllByMasterIdDesc(int id) {
        return ResponseEntity.ok(reviewService.getAllReviewsByMasterIdDesc(id));
    }*/

  /*  @GetMapping
    public ResponseEntity<List<Review>>findAllByClientIdAsc(@PathVariable int id) {
        return ResponseEntity.ok(reviewService.getAllReviewsByClientIdAsc(id));
    }

    @GetMapping
    public ResponseEntity<List<Review>>findAllByClientIdDesc(int id) {
        return ResponseEntity.ok(reviewService.getAllReviewsByClientIdDesc(id));
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok("ok");}

}
