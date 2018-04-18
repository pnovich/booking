package com.example.springdata2.Entities;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "room")
public class Room implements Serializable {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6)
    private long id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "category_id")
    private Category category;


    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Boocking> boockingList;

    public Room() {
    }

    public Room(Category category) {
        this.category = category;
        this.boockingList = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Boocking> getBoockingList() {
        return boockingList;
    }

    public void setBoockingList(List<Boocking> boockingList) {
        this.boockingList = boockingList;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Room{" +
                "id=" + id +
//                ", category=" + category +
////                ", boockingList=" + boockingList +
                '}';
    }
}

