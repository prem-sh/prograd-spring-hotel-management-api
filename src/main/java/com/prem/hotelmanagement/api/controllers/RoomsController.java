package com.prem.hotelmanagement.api.controllers;

import com.prem.hotelmanagement.api.models.Room;
import com.prem.hotelmanagement.api.requestSchemas.ConstructRoom;
import com.prem.hotelmanagement.api.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomsController {

    @Autowired
    RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("filter")
    public List<Room> getAllRooms(@RequestParam(name = "status") String status,
                                  @RequestParam(name = "type") String type
    ) {
        return roomService.getRoomsByStatusAndType(status, type);
    }

    @GetMapping("/{status}/{type}")
    public List<Room> getRoomsByStatusAndType(@PathVariable("status") String status, @PathVariable("type") String type) {
        return roomService.getRoomsByStatusAndType(status, type);
    }

    @GetMapping("status/{status}")
    public List<Room> getRoomsByStatus(@PathVariable String status) {
        return roomService.getRoomsByStatus(status);
    }

    @GetMapping("type/{type}")
    public List<Room> getRoomsByType(@PathVariable String type) {
        return roomService.getRoomsByType(type);
    }

    @PostMapping
    public ResponseEntity<String> createRoom(@RequestBody ConstructRoom room) {
        return roomService.createRoom(room);
    }
}

