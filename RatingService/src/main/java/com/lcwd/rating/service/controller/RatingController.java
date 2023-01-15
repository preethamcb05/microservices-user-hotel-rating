package com.lcwd.rating.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.service.entity.Rating;
import com.lcwd.rating.service.services.RatingService;

@RestController
@RequestMapping("/Ratings")
public class RatingController {
	
	@Autowired
	public RatingService us;

	@PostMapping
	public ResponseEntity<Rating> createUser(@RequestBody Rating user)
	{
		Rating u = us.saveRating(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(u);
		
	}
	
	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getSingleUser(@PathVariable String ratingId)
	{
		Rating u = us.getRatingById(ratingId);
		return ResponseEntity.ok(u);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Rating>> getRating()
	{
		List<Rating> u = us.getAllRating();
		return ResponseEntity.ok(u);
	}
	
	@GetMapping("ByUserId/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId)
	{
		List<Rating> u = us.getRatingByUserId(userId);
		
		return ResponseEntity.ok(u);
	}
	
	@GetMapping("ByHotelId/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId)
	{
		List<Rating> u = us.getRatingByHotelId(hotelId);
		
		return ResponseEntity.ok(u);
	}
}
