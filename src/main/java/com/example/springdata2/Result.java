package com.example.springdata2;

import com.example.springdata2.Entities.Category;

public class Result {
    private long id;
    private String roomCategory;
    private long mainPrice;
    private   long addPrice;

    public Result() {
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Result{" +
                "id=" + id +
                ", roomCategory=" + roomCategory +
                ", mainPrice=" + mainPrice +
                ", addPrice=" + addPrice +
                '}';
    }

    public long getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(long addPrice) {
        this.addPrice = addPrice;
    }

    public long getMainPrice() {

        return mainPrice;
    }

    public void setMainPrice(long mainPrice) {
        this.mainPrice = mainPrice;
    }

    public String getRoomCategory() {

        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
