package com.example.springdata2;

import com.example.springdata2.Entities.Boocking;
import com.example.springdata2.Entities.Room;
import com.example.springdata2.Entities.UserTable;
import com.example.springdata2.Service.BoockingService;
import com.example.springdata2.Service.RoomService;
import com.example.springdata2.Service.UserTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class Controller {
    @Autowired
    BoockingService boockingService;
    @Autowired
    RoomService roomService;
    @Autowired
    UserTableService userTableService;

    @GetMapping("/bookings")
    public List<Boocking> getAllBookings() {
        return (List<Boocking>)boockingService.getAll();
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return (List<Room>)roomService.getAll();
    }



    @GetMapping("/getfree")
    public ArrayList<Result> getFreeRooms(
                                        @RequestParam(value = "string1") String stringDate1,
                                        @RequestParam(value = "string2") String stringDate2){

        List<Result> resultList = new ArrayList<Result>();
        List<Room> list1 = new ArrayList<>();
        list1 = (ArrayList<Room>)roomService.getAll();
        System.out.println(list1);
        List<Room> list2 = new ArrayList<>();
        Iterator<Room> iter = list1.iterator();
        while(iter.hasNext()){
            boolean isFree = true;
            Room room = new Room();
            room = iter.next();
            long roomId = room.getId();
            isFree = roomService.roomIsFree(roomId,stringDate1,stringDate2);
            if (isFree) {
                list2.add(room);
                Result res = new Result();
                res.setId(roomId);
                res.setRoomCategory(room.getCategory().getCategoryName());
                res.setMainPrice(room.getCategory().getCategoryPrice());
                res.setAddPrice(room.getCategory().getAddPrice());
                resultList.add(res);
                System.out.println("result" + res);
            }
        }
//        System.out.println(list2);
        return (ArrayList<Result>)resultList;
    }


    @PostMapping("/createbooking/{userid}")
    public Boocking createBooking(@PathVariable(value = "userid") long userid,
                                 @RequestParam(value = "roomId") long roomId,
                                 @RequestParam(value = "string1") String stringDate1,
                                 @RequestParam(value = "string2") String stringDate2,
                                  @RequestParam(value = "ad") boolean ad){

        return boockingService.createBoockingByString(userid,roomId,stringDate1,stringDate2,ad);
    }

    @PostMapping("/createuser/{username}")
    public UserTable createUser(
            @PathVariable(value = "username") String userName){
              UserTable userTable = new UserTable();
              userTable.setUserName(userName);
        return userTableService.createUser(userTable);
    }

    @GetMapping("/viewbooking/{id}")
    public Boocking viewBoocking(
            @PathVariable(value = "id") long id)
    {
        UserTable userTable = userTableService.findUserTable(id);
        return userTable.getBoocking();
    }
    @GetMapping("/bookingprice/{id}")
    public long boockingPrice(
            @PathVariable(value = "id") long id){
        return boockingService.getBoockingPrice(id);
    }

    @GetMapping("/category/{id}")
    public ArrayList<Result> roomsByCategory(
            @PathVariable(value = "id") long categoryId){
         ArrayList<Room> rooms = (ArrayList)roomService.getRoomByCategory(categoryId);
         ArrayList<Result> result  = new ArrayList<>();
         Iterator<Room> it =rooms.iterator();
         while (it.hasNext()){
             Room room = it.next();
             Result res = new Result();
             res.setId(room.getId());
             res.setRoomCategory(room.getCategory().getCategoryName());
             res.setMainPrice(room.getCategory().getCategoryPrice());
             res.setAddPrice(room.getCategory().getAddPrice());
             result.add(res);
         }
         return result;
    }

}
