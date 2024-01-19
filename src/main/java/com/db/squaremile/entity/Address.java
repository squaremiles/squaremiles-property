package com.db.squaremile.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Address {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long addressId;
	
	private String addressOne;
	
	private String addresstwo;
	
	private String city;
	
	private String pin;
	
	private String state;
	
	@Embedded
	CommonEntity commonEntity;
	
	
}
