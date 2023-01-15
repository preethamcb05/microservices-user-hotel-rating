package com.lcwd.hotel.service.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "micro_hotels")
public class Hotel {

	@Id
	@Column(name="ID")
	private String hotelId;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ABOUT")
	private String about;
	
}
