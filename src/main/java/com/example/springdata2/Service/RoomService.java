package com.example.springdata2.Service;

import com.example.springdata2.Entities.Room;
import java.util.*;

public interface RoomService {
    List<Room> getAll();
    Room findRoom(long id);
    List<Room> getRoomByCategory(long id);
    boolean roomIsFree(long roomId, String date1,String date2);
}
