package com.example.springdata2.Service;

import com.example.springdata2.Entities.Boocking;
import java.util.*;


public interface BoockingService {
    List<Boocking> getAll();
    Boocking createBoockingByString(long userId,long roomId, String date1,String date2, boolean ad);
    boolean checkDate(Boocking boocking, String date1, String date2);
    Boocking findBooking(long id);
    long getBoockingPrice(long userId);
}
