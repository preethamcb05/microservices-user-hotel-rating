package com.lcwd.rating.service.entity;

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
@Table(name = "micro_user_hotel_rating")
public class Rating {

	@Id
	@Column(name="ID")
	private String ratingId;
	
	@Column(name="USERID")
	private String userId;
	
	@Column(name="HOTELID")
	private String hotelId;
	
	@Column(name="RATING")
	private int rating;
	
	@Column(name="FEEDBACK")
	private String feedback;
	
}
