package com.property.Coliving_Listing_Platform.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document
public class Property {
    @Id
    private UUID propertyId;
    private String propertyName;
    private Address address;
    private Date creationDate;
    private Date updationDAte;
    private List listOfFloors;
    private int numberOfFloors;
    private PropertyType propertyType;
    private Boolean propertyStatus;

    public enum PropertyType {
        CO_LIVING,
        MEN,
        WOMEN

    }
    public String amenities;


    public Property() {
        this.propertyId = UUID.randomUUID();
    }

    public UUID getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(UUID propertyId) {
        this.propertyId = propertyId;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdationDAte() {
        return updationDAte;
    }

    public void setUpdationDAte(Date updationDAte) {
        this.updationDAte = updationDAte;
    }

    public List getListOfFloors() {
        return listOfFloors;
    }

    public void setListOfFloors(List listOfFloors) {
        this.listOfFloors = listOfFloors;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Boolean getPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(Boolean propertyStatus) {
        this.propertyStatus = propertyStatus;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }
}


