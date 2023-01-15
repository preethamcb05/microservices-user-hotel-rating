package com.lcwd.hotel.service.controller;

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

import com.lcwd.hotel.service.entities.Hotel;
import com.lcwd.hotel.service.services.HotelService;





@RestController
@RequestMapping("/Hotels")
public class HotelController {
	
	@Autowired
	public HotelService us;

	@PostMapping
	public ResponseEntity<Hotel> createUser(@RequestBody Hotel user)
	{
		Hotel u = us.saveHotel(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(u);
		
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleUser(@PathVariable String hotelId)
	{
		Hotel u = us.getHotelById(hotelId);
		return ResponseEntity.ok(u);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> getUsers()
	{
		List<Hotel> u = us.getAllHotel();
		return ResponseEntity.ok(u);
	}
}
