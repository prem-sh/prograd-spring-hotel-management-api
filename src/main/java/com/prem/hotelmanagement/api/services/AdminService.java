package com.prem.hotelmanagement.api.services;

import com.prem.hotelmanagement.api.models.Room;


import java.util.Date;

public interface AdminService {
    String getTotalRevenue();
    String getTotalRevenue(Date from, Date to);
    String getRevenueFromRoom(int id);
    String getRevenueFromRoom(int id, Date from, Date to);

    String SignInRoom(int userId, int roomId);
    String signOutRoom(long bookingId);
}
