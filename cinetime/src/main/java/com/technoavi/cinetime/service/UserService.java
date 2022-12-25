package com.technoavi.cinetime.service;

import com.technoavi.cinetime.dao.model.User;
import com.technoavi.cinetime.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserJson() {
        return new User();
    }
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    private User copyUser(User oldUser, User newUser) {
        oldUser.setName(newUser.getName());
        oldUser.setAddress(newUser.getAddress());
        oldUser.setMobile(newUser.getMobile());
        oldUser.setEmail(newUser.getEmail());
        return oldUser;
    }

    public User updateUserById(int id, User newUser) {
        User oldUser = userRepository.findById(id).get();
        return userRepository.save(copyUser(oldUser, newUser));
    }

//    public User updateUserByName() {
//      userRepository
//    }

    public String deleteUserById(int id) {
        userRepository.deleteById(id);
        return "User deleted!!";
    }

    public String getUserByUserName(String userName) {
        return userRepository.findByUserName(userName).toString();
    }
}
