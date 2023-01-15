package com.lcwd.hotel.service.services;

import java.util.List;

import com.lcwd.hotel.service.entities.Hotel;


public interface HotelService {
	
	//Create
	Hotel saveHotel(Hotel hotel);
	
	//list
	List<Hotel> getAllHotel();
	
	//get single user
	Hotel getHotelById(String hotelId);

}
