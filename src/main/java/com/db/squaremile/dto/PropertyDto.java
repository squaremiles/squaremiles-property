package com.db.squaremile.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PropertyDto {
	
private String propertyName;
	
	private String propertyDesc;
	
	private String city;
	
	private String pin;
	
	private String state;
	
	private Long property_id;	
	
    private LocalDate createdTs;
	
	
	private LocalDate updatedTs;

}
