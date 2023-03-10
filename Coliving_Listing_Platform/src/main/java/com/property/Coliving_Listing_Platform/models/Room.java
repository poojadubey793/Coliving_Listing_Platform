package com.property.Coliving_Listing_Platform.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Room {
    private int roomNo;
    private int numberOfBeds;
    private List<Bed> beds;
    private RoomType roomType;
    private Boolean roomStatus;

    public enum RoomType {
        AC_ROOM,
        NON_AC_ROOM
    }

    public List<Bed> getBeds() {
        return beds;
    }

    public void setBeds(List<Bed> beds) {
        this.beds = beds;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public Boolean getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Boolean roomStatus) {
        this.roomStatus = roomStatus;
    }
}
