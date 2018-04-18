package com.example.springdata2.Entities;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "category")
public class Category implements Serializable  {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6)
    private long id;

    @Column(name = "categoryname")
    private String categoryName;

    @Column(name = "categoryprice")
    private long categoryPrice;

    @Column(name = "addprice")
    private long addPrice;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Room> rooms;

    public Category() {
    }

    public Category(long id, String categoryName, long categoryPrice, long addprice){
        this.id = id;
        this.categoryName = categoryName;
        this.categoryPrice = categoryPrice;
        this.addPrice = addprice;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategoryPrice() {
        return categoryPrice;
    }

    public void setCategoryPrice(long categoryPrice) {
        this.categoryPrice = categoryPrice;
    }

    public long getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(long addPrice) {
        this.addPrice = addPrice;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Category{" +
                "id=" + id +
//                ", categoryName='" + categoryName + '\'' +
//                ", categoryPrice=" + categoryPrice +
//                ", addPrice=" + addPrice +
////                ", rooms=" + rooms +
                '}';
    }
}
