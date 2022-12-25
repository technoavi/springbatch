package com.technoavi.cinetime.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "user_credential")
@Data
@JsonIgnoreProperties
@Component
public class UserCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "user_id")
    String userId;
    @Column(name = "name")
    String name;
    @Column(name = "password")
    String password;

//    public UserCredential() {}
//    public UserCredential(UserSignUp userSignUp) {
//        this.name = userSignUp.getFirstName() + " " + userSignUp.getLastName();
//        this.userId = userSignUp.getUserId();
//        this.password = userSignUp.getPassword();
//    }
}
