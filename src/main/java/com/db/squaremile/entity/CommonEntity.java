package com.db.squaremile.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.db.squaremile.enums.UserType;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Embeddable
public class CommonEntity {
	
	@CreationTimestamp
    private LocalDate createdTs;
	
	@UpdateTimestamp
	private LocalDate updatedTs;
	
	private Boolean isActive=Boolean.TRUE;

}
