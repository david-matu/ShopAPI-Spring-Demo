package com.shop.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PUBLIC, force=true)
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int productId;
	
	private String name;
	
	private double price;
	
	private LocalDateTime dateAdded;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "productID")
	private List<Review> reviews = new ArrayList<>();
}
