package com.example.springdata2.Entities;

import javax.persistence.*;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;
import java.time.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.Duration;


@Entity
@Table(name = "boocking")
public class Boocking implements Serializable {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6)
    private long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "usertable_id")
    private UserTable userTable;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonManagedReference
    private Room room;

    @Column(name = "date1")
    private java.time.LocalDate date1;

    @Column(name = "date2")
    private java.time.LocalDate date2;

    @Column(name = "additional")
    private boolean additional;

    public Boocking() {
//        this.additional = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserTable getUserTable() {
        return userTable;
    }

    public void setUserTable(UserTable userTable) {
        this.userTable = userTable;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setDate1(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = date1;
        localDate = LocalDate.parse(date, formatter);
        this.date1 = localDate;
    }

    public java.time.LocalDate getDate1() {
        return date1;
    }

    public void setDate2(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = date1;
        localDate = LocalDate.parse(date, formatter);
        this.date2 = localDate;
    }

    public java.time.LocalDate getDate2() {
        return date2;
    }



    public boolean isAdditional() {
        return additional;
    }

    public void setAdditional(boolean additional) {
        this.additional = additional;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Boocking{" +
                "id=" + id +
//                ", userTable=" + userTable +
                ", room=" + room +
//                ", date1=" + date1 +
//                ", date2=" + date2 +
                '}';
    }
}
