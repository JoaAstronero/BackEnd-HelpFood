package com.joaquin.restaurante_crud.services.impl;

import com.joaquin.restaurante_crud.dtos.reviewsDTOs.CreateReviewDTO;
import com.joaquin.restaurante_crud.dtos.reviewsDTOs.ReviewDTO;
import com.joaquin.restaurante_crud.entities.Restaurant;
import com.joaquin.restaurante_crud.entities.Review;
import com.joaquin.restaurante_crud.entities.User;
import com.joaquin.restaurante_crud.mappers.ReviewMapper;
import com.joaquin.restaurante_crud.repositories.RestaurantRepository;
import com.joaquin.restaurante_crud.repositories.ReviewRepository;
import com.joaquin.restaurante_crud.repositories.UserRepository;
import com.joaquin.restaurante_crud.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, UserRepository userRepository,RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public ReviewDTO createReview(CreateReviewDTO createReviewDTO) {
        User user = userRepository.findById(createReviewDTO.getUserId()).orElseThrow(()-> new RuntimeException("User Not Found"));
        Restaurant restaurant = restaurantRepository.findById(createReviewDTO.getRestaurantId()).orElseThrow(()-> new RuntimeException("Restaurant Not Found"));
        Review review = new Review();
        review.setUser(user);
        review.setRestaurant(restaurant);
        review.setRating(createReviewDTO.getRating());
        review.setComment(createReviewDTO.getComment());
        review.setCreatedAt(LocalDateTime.now());

        return ReviewMapper.toReviewDTO(reviewRepository.save(review));
    }

    @Override
    public ReviewDTO updateReview(ReviewDTO reviewDTO) {
        return null;
    }

    @Override
    public List<ReviewDTO> getReviewsByRestaurant(Integer restaurantId) {
        List<Review> reviews = reviewRepository.findByRestaurantId(restaurantId);
        return reviews.stream().map(ReviewMapper::toReviewDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteReview(Integer reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
