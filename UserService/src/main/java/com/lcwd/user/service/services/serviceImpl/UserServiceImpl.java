package com.lcwd.user.service.services.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.external.services.HotelService;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		System.out.println(user.getEmail());
		System.out.println(user.getAbout());
		System.out.println(user.getName());
		return ur.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	@Override
	public User getUserById(String userId) {
		//Get user details by userId
		// TODO Auto-generated method stub
		User user = ur.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with user userId "+userId));
		
		//fetch rating by userId
		
		
		ResponseEntity<List<Rating>> rateResponse =
		        restTemplate.exchange("http://RATING-SERVICE/Ratings/ByUserId/"+user.getUserId(),
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Rating>>() {
		            });
		
		
		List<Rating> rating = rateResponse.getBody();
		for(int i=0; i<rating.size();i++)
		{
			//Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/Hotels/"+rating.get(i).getHotelId(), Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.get(i).getHotelId());
			rating.get(i).setHotel(hotel);	
		}
		
		
		user.setRatings(rating);
		return user;
	}

}
