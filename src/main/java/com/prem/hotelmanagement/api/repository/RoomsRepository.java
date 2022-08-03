package com.prem.hotelmanagement.api.repository;

import com.prem.hotelmanagement.api.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomsRepository extends JpaRepository<Room, Integer> {

    @Query("select r from Room r where r.roomStatus.name like ?1 order by r.roomId")
    List<Room> findRoomsByStatus(String name);
    @Query("select r from Room r where r.roomType.name like ?1 order by r.roomId")
    List<Room> findRoomsByType(String name);

    @Query("select r from Room r " +
            "where upper(r.roomStatus.name) like upper(?1) and upper(r.roomType.name) like upper(?2) " +
            "order by r.roomId")
    List<Room> findRoomsByStatusAndType(String name, String name1);
    
}
