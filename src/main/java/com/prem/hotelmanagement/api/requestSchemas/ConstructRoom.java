package com.prem.hotelmanagement.api.requestSchemas;

import java.io.Serializable;

public class ConstructRoom implements Serializable {
    private int roomNumber;
    private String type;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
