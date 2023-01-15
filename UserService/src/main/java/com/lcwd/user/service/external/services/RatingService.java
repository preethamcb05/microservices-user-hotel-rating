package com.lcwd.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {

	@PostMapping("/Ratings")
	public ResponseEntity<Rating> createRating(Rating values);
	
	@PutMapping("/Ratings/{ratingId}")
	public Rating updateRating(@PathVariable("ratingId") String ratingId,Rating values);
	
	@DeleteMapping("/Ratings/{ratingId}")
	public Rating deleteRating(@PathVariable("ratingId") String ratingId);
	
	
}
