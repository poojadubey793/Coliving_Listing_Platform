package com.property.Coliving_Listing_Platform.models;

public class Filter {

    private String city;
    private Property propertyType;
    private Boolean status;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Property getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Property propertyType) {
        this.propertyType = propertyType;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
