package com.property.Coliving_Listing_Platform.models;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Bed {
    private String bedNumber;
    private BedType bedType;
    private Boolean bedStatus;

    private enum BedType {
        SINGLE,
        DOUBLE,
        QUEEN,
        KING
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    public Boolean getBedStatus() {
        return bedStatus;
    }

    public void setBedStatus(Boolean bedStatus) {
        this.bedStatus = bedStatus;
    }
}
