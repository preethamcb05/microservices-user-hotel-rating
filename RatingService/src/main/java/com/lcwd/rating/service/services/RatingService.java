package com.lcwd.rating.service.services;

import java.util.List;

import com.lcwd.rating.service.entity.Rating;


public interface RatingService {
	
	//Create
	Rating saveRating(Rating rating);
	
	//list
	List<Rating> getAllRating();
	
	//get single user
	Rating getRatingById(String ratingId);

	List<Rating> getRatingByUserId(String ratingId);

	List<Rating> getRatingByHotelId(String hotelId);

}
