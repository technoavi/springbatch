package com.technoavi.cinetime.service;

import com.technoavi.cinetime.dao.model.User;
import com.technoavi.cinetime.dao.model.UserCredential;
import com.technoavi.cinetime.dao.model.UserSignUp;
import com.technoavi.cinetime.dao.repositories.UserCredentialRepository;
import com.technoavi.cinetime.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSignUpService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserCredentialRepository userCredentialRepository;

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
        userCredential.setPassword((userSignUp.getPassword()));

        userCredentialRepository.save(userCredential);
        return userRepository.save(user);
    }
}
