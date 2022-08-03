package com.prem.hotelmanagement.api.repository;

import com.prem.hotelmanagement.api.models.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface RoomTypeRepo extends JpaRepository<RoomType, Integer> {
    @Query("select r from RoomType r inner join r.rooms rooms where upper(rooms.roomType.name) like upper(?1)")
    Optional<RoomType> findByName(String name);

}
