package com.shop.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.shop.api.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
