package com.geekster.HotelManagement.service;

import com.geekster.HotelManagement.model.HotelRoom;
import com.geekster.HotelManagement.model.Type;
import com.geekster.HotelManagement.repository.IRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    IRoomRepo roomRepo;

    public Iterable<HotelRoom> getAllRooms() {
        return roomRepo.findAll();
    }

    public String addRoom(HotelRoom room) {
        roomRepo.save(room);
        return "room is added";
    }

    public String addRooms(List<HotelRoom> rooms) {
        roomRepo.saveAll(rooms);
        return "rooms are added successfully"+ rooms;
    }

    public HotelRoom getRoomById(Long id) {
        return roomRepo.getAllRoomById(id);
    }

    public boolean checkRoomExists(Long id) {
        return roomRepo.existsById(id);
    }

    public Long getTotalRooms() {
        return roomRepo.count();
    }

    public String deleteRoomById(Long id) {
        roomRepo.deleteById(id);
        return "Room is deleted with id "+id;
    }

    public String updateRoomById(Long id, Type type) {
        Optional<HotelRoom> myRoomOpt = roomRepo.findById(id);
        HotelRoom myRoom = null;
        if (myRoomOpt.isPresent()) {
            myRoom = myRoomOpt.get();
        }else {
            return "id not Found!!!";
        }
        myRoom.setRoomType(type);
        roomRepo.save(myRoom);
        return "room type updates";
    }

    public List<HotelRoom> getRoomsByStatus(Boolean status) {
        return roomRepo.findByRoomStatus(status);
    }

    public List<HotelRoom> getRoomsByStatusAndType(Boolean status, Type type) {
        return  roomRepo.findByRoomStatusAndRoomType(status,type);
    }

    public List<HotelRoom> getRoomsByStatusAndTypeAndPrice(Boolean status, Type type, Double lLimit, Double uLimit) {
        return roomRepo.findByRoomStatusAndRoomTypeAndRoomPriceGreaterThanAndRoomPriceLessThan(status,type,lLimit,uLimit);
    }

    public List<HotelRoom> getRoomsByTypeAndPriceSortedDesc(Type roomType) {
        return roomRepo.findByRoomTypeOrderByRoomPriceDesc(roomType);
    }

    public List<HotelRoom> getBudgetedAcOrNonAC(Type roomType1, Type roomType2, Double lLimit, Double uLimit) {
        return  roomRepo.findByRoomTypeAndRoomPriceBetweenOrRoomType(roomType1,lLimit,uLimit,roomType2);
    }
}
