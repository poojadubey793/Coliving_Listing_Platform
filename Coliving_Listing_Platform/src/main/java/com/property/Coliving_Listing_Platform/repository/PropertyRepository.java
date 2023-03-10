package com.property.Coliving_Listing_Platform.repository;

import com.property.Coliving_Listing_Platform.models.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PropertyRepository extends MongoRepository<Property, UUID> {

    @Query("{ 'propertyName' : { $regex: '(?i)?0' } }")
    List<Property> findPropertyByRegexpName(String propertyName);

    @Query(" {'cityName' : {$regex: '(?i)?0' } }")
    List<Property> findPropertyByCity(String cityName);

}
