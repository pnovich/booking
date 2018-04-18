package com.example.springdata2.Entities;

import javax.persistence.*;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "usertable")
public class UserTable implements Serializable {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6)
    private long id;

    @Column(name = "username")
    private String userName;

    @OneToOne(mappedBy = "userTable", cascade = CascadeType.ALL)
    @JsonBackReference
    private Boocking boocking;

    public UserTable() {
    }
//    public UserTable(String name) {
//        this.userName = name;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boocking getBoocking() {
        return boocking;
    }

    public void setBoocking(Boocking boocking) {
        this.boocking = boocking;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "UserTable{" +
                "id=" + id +
                ", userName='" + userName + '\'' +

//                ", boocking=" + boocking +
                '}';
    }
}
