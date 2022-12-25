package com.technoavi.cinetime.service;

import com.technoavi.cinetime.dao.model.User;
import com.technoavi.cinetime.dao.model.UserCredential;
import com.technoavi.cinetime.dao.model.UserSignUp;
import com.technoavi.cinetime.dao.repositories.UserCredentialRepository;
import com.technoavi.cinetime.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserSignUpService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserCredentialRepository userCredentialRepository;

    public static String encode(String password) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(password.getBytes());
    }
    public User save(UserSignUp userSignUp) {
        User user = new User();
        user.setEmail(userSignUp.getEmail());
        user.setName(userSignUp.getName());
        user.setAddress(userSignUp.getAddress());
        user.setMobile(userSignUp.getMobile());
        user.setUserName(userSignUp.getUserId());

        UserCredential userCredential = new UserCredential();
        userCredential.setName(userSignUp.getName());
        userCredential.setUserId(userSignUp.getUserId());


        userCredential.setPassword(encode(userSignUp.getPassword()));

        userCredentialRepository.save(userCredential);
        return userRepository.save(user);
    }
}
