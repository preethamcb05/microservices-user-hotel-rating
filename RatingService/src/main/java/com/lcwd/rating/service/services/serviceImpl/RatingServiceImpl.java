package com.lcwd.rating.service.services.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lcwd.rating.service.entity.Rating;
import com.lcwd.rating.service.exceptions.ResourceNotFoundException;
import com.lcwd.rating.service.repository.RatingRepository;
import com.lcwd.rating.service.services.RatingService;


@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository ur;

	@Override
	public Rating saveRating(Rating rating) {
		// TODO Auto-generated method stub
		String randomUserId = UUID.randomUUID().toString();
		rating.setRatingId(randomUserId);
		
		return ur.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	@Override
	public Rating getRatingById(String ratingId) {
		// TODO Auto-generated method stub
		return ur.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("Hotel not found with user ratingId "+ratingId));
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return ur.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ur.findByHotelId(hotelId);
	}

}
