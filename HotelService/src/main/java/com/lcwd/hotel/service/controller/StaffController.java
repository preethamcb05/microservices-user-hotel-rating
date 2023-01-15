package com.lcwd.hotel.service.controller;

import java.util.Arrays;
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
@RequestMapping("/Staff")
public class StaffController {
	
	@GetMapping("/")
	public ResponseEntity<List<String>> getStaffs()
	{
		List<String> u = Arrays.asList("Ram","Sham","Sita","Krishna");
		return ResponseEntity.ok(u);
	}
}
