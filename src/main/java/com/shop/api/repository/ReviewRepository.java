package com.shop.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.shop.api.model.Review;

public interface ReviewRepository extends CrudRepository<Review, Integer> {

}
