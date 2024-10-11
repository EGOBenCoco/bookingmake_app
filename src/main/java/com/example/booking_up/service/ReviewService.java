package com.example.booking_up.service;

import com.example.booking_up.entity.Review;
import com.example.booking_up.repository.ReviewRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class ReviewService {
    ReviewRepository reviewRepository;

    public void createReview(Review review){
        reviewRepository.save(review);
    }

    public Optional<Review> getReviewById(int id){
        return reviewRepository.findById(id);
    }

    public List<Review> getAllReviewsByMasterId(int id){return reviewRepository.findAllById(id);}

    public List<Review> getAllReviewsByClientId(int id){return reviewRepository.findAllById(id);}

    public List<Review> getAllReviewsByMasterIdAsc(int id){return reviewRepository.findByRatingOrderByRatingAsc(id);}

    public List<Review> getAllReviewsByMasterIdDesc(int id){return reviewRepository.findByRatingOrderByRatingDesc(id);}

    public List<Review> getAllReviewsByClientIdAsc(int id){return reviewRepository.findByRatingOrderByRatingAsc(id);}

    public List<Review> getAllReviewsByClientIdDesc(int id){return reviewRepository.findByRatingOrderByRatingDesc(id);}

    public void deleteReview(int id){
        reviewRepository.deleteById(id);
    }
}
// сделать два метода по получению всех отзывов по айди первый метод для клиента, а второй для мастера
// та же ситуация для методов сортировки по рейтингу
// вызвать эти методы в контроллере и протестировать