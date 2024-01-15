package com.shop.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="reviews")
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Review {
	
	public Review(int productID, String review) {
		this.review = review;
		this.setReviewDate(LocalDateTime.now()); //(System.currentTimeMillis()));
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REVIEW_ID")
	private int reviewID;
	
	@Column(name = "PRODUCT_ID")
	private long refProductID;
	
	private String review;
	
	private LocalDateTime reviewDate;
}
