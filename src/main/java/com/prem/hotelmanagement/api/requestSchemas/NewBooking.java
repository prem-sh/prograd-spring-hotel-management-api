package com.prem.hotelmanagement.api.requestSchemas;

public class NewBooking {
    private int customerId;
    private int roomId;
    private String inTime;
    private String outTime;

    public NewBooking() {
    }

    public NewBooking(int customerId, int roomId, String inTime) {
        this.customerId = customerId;
        this.roomId = roomId;
        this.inTime = inTime;
    }

    public NewBooking(int customerId, int roomId, String inTime, String outTime) {
        this.customerId = customerId;
        this.roomId = roomId;
        this.inTime = inTime;
        this.outTime = outTime;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }
}
