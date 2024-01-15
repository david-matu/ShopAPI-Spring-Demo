package com.shop.api.rest;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shop.api.model.Product;
import com.shop.api.repository.ProductRepository;

@RestController
@RequestMapping(path="/api/products", produces="application/json")
@CrossOrigin(origins="*")	//http://localhost:8080
public class ProductsController {
	
	private final ProductRepository productRepo;	
	
	public ProductsController(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	@GetMapping
	public Iterable<Product> allProducts() {
		return productRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> productById(@PathVariable("id") int id) {
		Optional<Product> optProduct = productRepo.findById(id);
		
		if(optProduct.isPresent()) {
			return new ResponseEntity<>(optProduct.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product product) {
		product.setDateAdded(LocalDateTime.now());	//new Timestamp(System.currentTimeMillis()));
		
		Product savedProduct = productRepo.save(product); 
		return savedProduct;
	}
	
	@PutMapping(path="/{productId}", consumes="application/json")
	public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
		product.setProductId(productId);
		return productRepo.save(product);
	}
	
	@PatchMapping(path="/{productId}", consumes="application/json")
	public Product patchBlogProduct(@PathVariable("productId") int productId, @RequestBody Product patch) {
		Product prod = productRepo.findById(productId).get();
		
		if(patch.getName() != null) {
			prod.setName(patch.getName());
		}
		
		if(!(patch.getPrice() < 0)) {	// We can assume that a user updated price will never be less than zero
			prod.setPrice(patch.getPrice());
		}
		
		return productRepo.save(prod);
	}
	
	@DeleteMapping("/{productId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable("productId") int productId) {
		try {
			productRepo.deleteById(productId);
		} catch(EmptyResultDataAccessException e) {}
	}
}