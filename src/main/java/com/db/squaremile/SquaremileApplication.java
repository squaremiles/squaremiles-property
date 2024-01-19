package com.db.squaremile;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.db.squaremile.entity.Address;
import com.db.squaremile.entity.CommonEntity;
import com.db.squaremile.entity.Property;
import com.db.squaremile.entity.SquaremilesUser;
import com.db.squaremile.enums.UserType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.trace.export.SpanExporter;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class SquaremileApplication implements CommandLineRunner{

	public static void main(String[] args) {
		//Hooks.enableAutomaticContextPropagation();
		SpringApplication.run(SquaremileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		CommonEntity commonEntity=CommonEntity.builder().build();
		Address address=Address.builder().addressOne("BBSR").addresstwo("PATIA").city("Bhubaneswar").state("Orissa").
				commonEntity(commonEntity).pin("752079").build();
		SquaremilesUser user=SquaremilesUser.builder().email("kabi@db.com").name("kabi").userType(UserType.OWNER)
				.dob(LocalDate.of(1987, 07, 12)).build();
		Property property=Property.builder().propertyName("Indradahanu").	
		propertyDesc("Indiavidual").commonEntity(commonEntity).user(user).address(address).build();
		System.out.println(new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(property));
		
	}
	
	/*
	 * @Bean public SpanExporter OtlpGrpcSpanExporter() { return
	 * OtlpHttpSpanExporter .builder()
	 * .setEndpoint("http://localhost:4318/v1/traces") .build(); }
	 */

}
