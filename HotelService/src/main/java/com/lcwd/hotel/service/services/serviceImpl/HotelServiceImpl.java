package com.lcwd.hotel.service.services.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.service.entities.Hotel;
import com.lcwd.hotel.service.repository.HotelRepository;
import com.lcwd.hotel.service.services.HotelService;
import com.lcwd.hotel.service.exceptions.ResourceNotFoundException;


@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository ur;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		String randomUserId = UUID.randomUUID().toString();
		hotel.setHotelId(randomUserId);
		System.out.println(hotel.getLocation());
		System.out.println(hotel.getAbout());
		System.out.println(hotel.getName());
		return ur.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		// TODO Auto-generated method stub
		return ur.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel not found with user userId "+hotelId));
	}

}
