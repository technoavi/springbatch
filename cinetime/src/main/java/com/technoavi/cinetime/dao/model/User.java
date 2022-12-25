package com.technoavi.cinetime.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@JsonIgnoreProperties
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "mobile")
    long mobile;
    @Column(name = "address")
    String address;
    @Column(name = "email")
    String email;

    @Column(name = "user_id")
    String userName;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mobile=" + mobile +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    //    public User() {
//    }
//    public  User(UserSignUp userSignUp) {
//        this.name = userSignUp.getFirstName() + " " + userSignUp.getLastName();
//        this.mobile = userSignUp.getMobile();
//        this.address = userSignUp.getAddress();
//        this.email = userSignUp.getEmail();
//    }
}
