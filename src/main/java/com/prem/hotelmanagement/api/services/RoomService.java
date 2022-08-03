package com.prem.hotelmanagement.api.services;

import com.prem.hotelmanagement.api.models.Room;
import com.prem.hotelmanagement.api.requestSchemas.ConstructRoom;
import jdk.jshell.Snippet;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface RoomService {
    ResponseEntity<String> createRoom(ConstructRoom room);

    Room getRoomById(int id);
    List<Room> getRoomsByStatus(String status);
    List<Room>  getRoomsByType(String type);
    List<Room>  getRoomsByStatusAndType(String status,String type);
    List<Room> getAllRooms();

    boolean setRoomStatus(int id, String status);
}
