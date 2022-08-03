package com.prem.hotelmanagement.api.repository;

import com.prem.hotelmanagement.api.models.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface RoomStatusRepo extends JpaRepository<RoomStatus, Integer> {

    Optional<RoomStatus> findByRooms_RoomStatus_NameLikeIgnoreCase(String name);

}
