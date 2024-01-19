package com.db.squaremile.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.db.squaremile.dto.PropertyDto;
import com.db.squaremile.entity.Property;

import io.micrometer.observation.annotation.Observed;
import io.micrometer.tracing.Tracer;
import io.micrometer.tracing.annotation.ContinueSpan;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificationService {
	
	
	
	@Autowired 
	private Tracer tracer;
	
	@Autowired
	RestTemplate restTemplate;

	//@Observed(name = "post.property.notify" )
	/*
	 * public Mono<String> notify(Mono<Property> property){ String traceKey =
	 * "x-b3-traceid"; Mono<String> status=property.log().flatMap(it->{ Mono<String>
	 * callStatus = webclient.post() .uri("/notify")
	 * .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).
	 * header(traceKey, tracer.currentSpan().context().traceId().toString())
	 * .bodyValue(propertyToDto(it)) .retrieve() .bodyToMono(String.class); return
	 * callStatus; }); return status; }
	 */
	@Observed(name = "post.property.notify" )
	//@ContinueSpan
	public String notify(Property property){
		ResponseEntity<String> entity= restTemplate.postForEntity("http://localhost:8087/notify", propertyToDto(property), String.class);
		return entity.getBody();
		/*
		 * String traceKey = "x-b3-traceid"; Mono<String>
		 * status=property.log().flatMap(it->{ Mono<String> callStatus =
		 * webclient.post() .uri("/notify") .header(HttpHeaders.CONTENT_TYPE,
		 * MediaType.APPLICATION_JSON_VALUE). header(traceKey,
		 * tracer.currentSpan().context().traceId().toString())
		 * .bodyValue(propertyToDto(it)) .retrieve() .bodyToMono(String.class); return
		 * callStatus; }); return status;
		 */
	}
	
	public PropertyDto propertyToDto(Property property) {
		PropertyDto dto=PropertyDto.builder().build();
		BeanUtils.copyProperties(property, dto);
		dto.setCreatedTs(property.getCommonEntity().getCreatedTs());
		dto.setUpdatedTs(property.getCommonEntity().getUpdatedTs());
		return dto;
	}
}
