package com.db.squaremile.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.db.squaremile.enums.UserType;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class SquaremilesUser{
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Long userId;
	
	private String name;
	
	private String email;
	
	private LocalDate dob;
	
	private UserType userType;
	
	@Embedded
	private CommonEntity commonEntity;
	 
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<Property> properties;

}
