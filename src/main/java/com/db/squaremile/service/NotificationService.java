package com.db.squaremile.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.db.squaremile.dto.PropertyDto;
import com.db.squaremile.entity.Property;

import io.micrometer.observation.annotation.Observed;
import io.micrometer.tracing.Tracer;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificationService {
	
	
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${notifier.url}")
	private String notifierurl;
	

	
	@Observed(name = "post.property.notify" )	
	public String notify(Property property){
		log.info("squaremiles notifier called "+notifierurl);
		ResponseEntity<String> entity= restTemplate.postForEntity(notifierurl, propertyToDto(property), String.class);
		return entity.getBody();
		
	}
	
	public PropertyDto propertyToDto(Property property) {
		PropertyDto dto=PropertyDto.builder().build();
		BeanUtils.copyProperties(property, dto);
		dto.setCreatedTs(property.getCommonEntity().getCreatedTs());
		dto.setUpdatedTs(property.getCommonEntity().getUpdatedTs());
		return dto;
	}
}
