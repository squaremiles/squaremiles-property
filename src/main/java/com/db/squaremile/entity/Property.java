package com.db.squaremile.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Property{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long property_id;
	
	private String propertyName;
	
	private String propertyDesc;
	
	private String city;
	
	private String pin;
	
	private String state;
	
	@Embedded
	CommonEntity commonEntity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private SquaremilesUser user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
	
	
	
	
	
	

}
