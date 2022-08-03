package com.prem.hotelmanagement.api.services;

import com.prem.hotelmanagement.api.constants.AppConstants;
import com.prem.hotelmanagement.api.models.Room;
import com.prem.hotelmanagement.api.models.RoomStatus;
import com.prem.hotelmanagement.api.models.RoomType;
import com.prem.hotelmanagement.api.repository.RoomStatusRepo;
import com.prem.hotelmanagement.api.repository.RoomTypeRepo;
import com.prem.hotelmanagement.api.repository.RoomsRepository;
import com.prem.hotelmanagement.api.requestSchemas.ConstructRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    RoomsRepository roomsRepository;
    @Autowired
    RoomTypeRepo roomTypeRepo;
    @Autowired
    RoomStatusRepo roomStatusRepo;


    @Override
    public ResponseEntity<String> createRoom(ConstructRoom constructRoom) {
        Room room = new Room();
        Optional<RoomStatus> status =  roomStatusRepo.findById(AppConstants.RoomStatus.AVAILABLE.id());
        status.ifPresent(room::setRoomStatus);

        if(AppConstants.RoomTypes.validate(constructRoom.getType())){
            Optional<RoomType> type = roomTypeRepo.findById(AppConstants.RoomTypes.get(constructRoom.getType()).id());
            type.ifPresent(room::setRoomType);
        }else return new ResponseEntity<String>("Wrong room type, Available options are SINGLE | DOUBLE | TWIN | KING", HttpStatus.OK);
        System.out.println(constructRoom.getRoomNumber());
        if(constructRoom.getRoomNumber() != 0){
            room.setRoomNo(constructRoom.getRoomNumber());
            Room newRoom = roomsRepository.save(room);
            return new ResponseEntity<String>("The new Room added successfully, The New Room ID is : "+newRoom.getRoomId(), HttpStatus.OK);
        }else return new ResponseEntity<String>("Room number cannot be empty or 0", HttpStatus.OK);
    }

    @Override
    public Room getRoomById(int id) {
        Optional<Room> result = roomsRepository.findById(id);
        return (Room) result.orElse(null);
    }

    @Override
    public List<Room> getRoomsByStatus(String status) {
        if(AppConstants.RoomStatus.validate(status))
            return roomsRepository.findRoomsByStatus(status);
        return null;
    }

    @Override
    public List<Room> getRoomsByType(String type) {
        if (AppConstants.RoomTypes.validate(type))
            return roomsRepository.findRoomsByType(type);
        return null;
    }

    @Override
    public List<Room> getRoomsByStatusAndType(String status,String type) {
        if(AppConstants.RoomStatus.validate(status))
            if (AppConstants.RoomTypes.validate(type))
                return roomsRepository.findRoomsByStatusAndType(status, type);
        return null;
    }

    @Override
    public List<Room> getAllRooms() {
        return roomsRepository.findAll();
    }

    @Override
    public boolean setRoomStatus(int id, String status) {
        Optional<Room> result = roomsRepository.findById(id);
        if(result.isPresent()) {
            Optional<RoomStatus> state = roomStatusRepo.findByRooms_RoomStatus_NameLikeIgnoreCase(status);
            if(state.isPresent()){
                Room room = (Room) result.get();
                room.setRoomStatus((RoomStatus) state.get());
                roomsRepository.save(room);
                return true;
            }else return false;
        }
        return false;
    }
}
