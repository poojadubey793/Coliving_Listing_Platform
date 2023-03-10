package com.property.Coliving_Listing_Platform.controller;

import com.property.Coliving_Listing_Platform.models.Filter;
import com.property.Coliving_Listing_Platform.repository.PropertyRepository;
import com.property.Coliving_Listing_Platform.models.Property;
import com.property.Coliving_Listing_Platform.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/property")
@RestController
public class PropertyController {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyService propertyService;

    @PostMapping("/addProperty")
    public Property saveProperty(@RequestBody Property property){
        return propertyService.saveProperty(property);
    }

    @GetMapping("/findAllProperty")
    public List<Property> getProperties() {
        return propertyService.getProperties();
    }

    @GetMapping("/findPropertyById/{propertyId}")
    public Optional<Property> getProperty(@PathVariable UUID propertyId) {
        return Optional.ofNullable(propertyService.getProperty(propertyId));
    }


    @PutMapping("/updateProperty/{propertyId}")
    public Property updateProperty(@RequestBody Property property){
        return propertyService.updateProperty(property);
    }

    @DeleteMapping("/delete/{propertyId}")
    public String deleteProperty(@PathVariable UUID propertyId){
        return propertyService.deleteProperty(propertyId);
    }

    @GetMapping("/get/listing")
    public List<Property> listingWithPagination(@RequestParam int page, @RequestParam int size){
        return propertyService.listingWithPagination(page,size);
    }

    @GetMapping("/get/propertyName")
    public List<Property> findPropertyByRegexpName(@RequestParam String propertyName){
        return propertyService.findPropertyByRegexpName(propertyName);
    }

    @GetMapping("/get/property/cityName")
    public List<Property> findPropertyByCity(@RequestParam String cityName){
        return propertyService.findPropertyByCity(cityName);
    }

    @GetMapping("/filter")
    public List<Property> filterProperty(@RequestBody Filter filter ){
        return propertyService.filterProperty(filter);
    }
}
