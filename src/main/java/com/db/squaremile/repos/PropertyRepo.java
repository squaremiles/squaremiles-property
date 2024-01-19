package com.db.squaremile.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.squaremile.entity.Property;

import io.micrometer.observation.annotation.Observed;
@Observed(name = "post.property.repo" )
public interface PropertyRepo extends JpaRepository<Property,Long>{

}
