package com.db.squaremile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.squaremile.entity.Property;
import com.db.squaremile.repos.PropertyRepo;

import io.micrometer.core.annotation.Timed;
import io.micrometer.observation.annotation.Observed;
import io.micrometer.tracing.annotation.ContinueSpan;
import io.micrometer.tracing.annotation.SpanTag;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PropertyService {
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private PropertyRepo propertyRepo;
	
	@Observed(name = "post.property.service",contextualName ="postProperty",lowCardinalityKeyValues = {"property-value","plot"})
	public Property postProperty(@SpanTag(value = "property") Property property) {
		log.info("Calling repo ...");
		property=propertyRepo.save(property);
		try {
		notificationService.notify(property);
		}catch(Exception e) {
			log.error("error durring calling web service ",e);
		}
		return property;
		
	}
	
	@Observed(name = "retrive.property")
	public List<Property> getProperties() {
		return propertyRepo.findAll();
	}
	
	
	

}
