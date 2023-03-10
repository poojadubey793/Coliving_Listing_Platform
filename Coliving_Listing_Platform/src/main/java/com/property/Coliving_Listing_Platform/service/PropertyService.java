package com.property.Coliving_Listing_Platform.service;

import com.property.Coliving_Listing_Platform.models.Filter;
import com.property.Coliving_Listing_Platform.repository.PropertyRepository;
import com.property.Coliving_Listing_Platform.models.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository=propertyRepository;
    }


    public Property saveProperty(Property property) {
        return propertyRepository.save(property);
    }

    public List<Property> getProperties() {
        return propertyRepository.findAll();
    }

    public Property getProperty(UUID propertyId) {
        return propertyRepository.findById(propertyId).orElse(null);
    }

    public Property updateProperty(Property property) {
        AtomicReference<Property> propertyAtomicReference = new AtomicReference<>();
        Optional<Property> propertyOptional = propertyRepository.findById(property.getPropertyId());
        propertyOptional.ifPresent(data -> {
            propertyOptional.get().setPropertyName(property.getPropertyName());
            propertyOptional.get().setPropertyId(property.getPropertyId());
            propertyOptional.get().setCreationDate(property.getCreationDate());
            propertyOptional.get().setUpdationDAte(property.getUpdationDAte());
            propertyOptional.get().setAddress(property.getAddress());
            propertyOptional.get().setListOfFloors(property.getListOfFloors());
            propertyAtomicReference.set(propertyRepository.save(data));
        });
        return propertyAtomicReference.get();
    }

    public String deleteProperty(UUID propertyId) {
        propertyRepository.deleteById(propertyId);
        return "PROPERTY DELETED";
    }

    public List<Property> listingWithPagination(int page, int size) {
        Pageable pageable = (Pageable) PageRequest.of(page, size);
        Query query = new Query();
        query.with(pageable);
        List<Property> properties = mongoTemplate.find(query, Property.class);
        return properties;
    }

    public List<Property> findPropertyByRegexpName(String propertyName) {
        return propertyRepository.findPropertyByRegexpName(propertyName);
    }

    public List<Property> findPropertyByCity(String cityName) {
        return propertyRepository.findPropertyByCity(cityName);
    }

    public List<Property> filterProperty(Filter filter) {

        Query query = new Query();
        if (filter.getCity() != null) {
            query.addCriteria(Criteria.where("address.city").is(filter.getCity()));
        }

        if (filter.getPropertyType() != null) {
            query.addCriteria(Criteria.where("propertyType").is(filter.getPropertyType()));
        }

        if (filter.getStatus() != null) {
            query.addCriteria(Criteria.where("status").is(filter.getStatus()));
        }
        List<Property> properties=mongoTemplate.find(query,Property.class);
        return properties;
    }
}
