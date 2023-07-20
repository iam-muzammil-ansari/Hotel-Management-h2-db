package com.geekster.HotelManagement.controller;

import com.geekster.HotelManagement.model.HotelRoom;
import com.geekster.HotelManagement.model.Type;
import com.geekster.HotelManagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    RoomService roomService;

    // get all the list of rooms
    @GetMapping("rooms")
    public Iterable<HotelRoom> getAllRooms(){
        return roomService.getAllRooms();
    }

    // add a particular room
    @PostMapping("room")
    public String addRoom(@RequestBody HotelRoom hotelRoom){
         return roomService.addRoom(hotelRoom);
    }

    //----------------------------------------------------------------------------------------
    // get particular room by id
    @GetMapping("room/{id}")
    public HotelRoom getRoomById(@PathVariable Long id){
        return roomService.getRoomById(id);
    }

    //check room is present or not in the database
    @GetMapping("room/{id}/exists")
    public boolean checkRoomExists(@PathVariable Long id){
        return roomService.checkRoomExists(id);
    }


    // count total no. of rooms present
    @GetMapping("rooms/count")
    public Long getTotalRooms(){
        return roomService.getTotalRooms();
    }

    // delete a room by id
    @DeleteMapping("room/{id}")
    public String deleteRoomById(@PathVariable Long id){
        return roomService.deleteRoomById(id);
    }

    //add a room of list
    @PostMapping("rooms")
    public String addRooms(@RequestBody List<HotelRoom> rooms){
        return roomService.addRooms(rooms);
    }

    // update room type on the basis of roomId
    @PutMapping("room/{id}/{type}")
    public String updateRoomById(@PathVariable Long id,@PathVariable Type type){
        return roomService.updateRoomById(id,type);
    }


    //find rooms by status

    @GetMapping("rooms/status/{status}")
    public List<HotelRoom> getRoomsByStatus(@PathVariable Boolean status)
    {
        return roomService.getRoomsByStatus(status);
    }

    @GetMapping("rooms/status/{status}/type/{type}")
    public List<HotelRoom> getRoomsByStatusAndType(@PathVariable Boolean status,@PathVariable Type type)
    {
        return roomService.getRoomsByStatusAndType(status,type);
    }

    @GetMapping("rooms/status/{status}/type/{type}/priceRange")
    public List<HotelRoom> getRoomsByStatusAndTypeAndPrice(@PathVariable Boolean status,@PathVariable Type type, @RequestParam Double lLimit, @RequestParam Double uLimit)
    {
        return roomService.getRoomsByStatusAndTypeAndPrice(status,type,lLimit,uLimit);
    }

    //get rooms by type and Sorted Desc. Price
    @GetMapping("rooms/type/{roomType}")
    public List<HotelRoom> getRoomsByTypeAndPriceSortedDesc(@PathVariable Type roomType)
    {
        return roomService.getRoomsByTypeAndPriceSortedDesc(roomType);
    }

    // get budgeted Ac or Non Ac rooms
    @GetMapping("rooms/type1/{roomType1}/type2/{roomType2}")
    public List<HotelRoom> getBudgetedAcOrNonAC(@PathVariable Type roomType1,@PathVariable Type roomType2, @RequestParam Double lLimit,@RequestParam Double uLimit)
    {
        return roomService.getBudgetedAcOrNonAC( roomType1, roomType2, lLimit,uLimit);
    }

}
