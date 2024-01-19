package com.db.squaremile.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.squaremile.entity.Property;
import com.db.squaremile.service.PropertyService;

import io.micrometer.observation.annotation.Observed;
import io.micrometer.tracing.annotation.ContinueSpan;
import io.micrometer.tracing.annotation.SpanTag;

@RestController
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	
	
	
	
	
	@PostMapping(value = "/property",consumes =MediaType.APPLICATION_JSON_VALUE)
	//@Observed(name = "post.property" )
	
	public ResponseEntity<Property> postProperty( @RequestBody Property property){
		return new ResponseEntity<Property>(propertyService.postProperty(property),HttpStatus.OK);
	}
	
	@GetMapping(value = "/property")
	public ResponseEntity<List<Property>> getProperties(@RequestBody Property property){
		return new ResponseEntity<List<Property>>(propertyService.getProperties(),HttpStatus.OK);
	}

}
