package com.technoavi.cinetime.controllers;

import com.technoavi.cinetime.dao.model.User;
import com.technoavi.cinetime.dao.model.UserSignUp;
import com.technoavi.cinetime.service.UserCredentialService;
import com.technoavi.cinetime.service.UserService;
import com.technoavi.cinetime.service.UserSignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user") // localhost:8080/user
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserCredentialService userCredentialService;
    @Autowired
    UserSignUpService userSignUpService;

    @PostMapping("/save") // localhost:8080/user/save
    public String createUserSignup(@RequestBody UserSignUp userSignUp) {
        return userSignUpService.save(userSignUp).toString();
    }
//    @PostMapping("/save") // localhost:8080/user/save
//    public User createUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }

    @GetMapping("/getall") // localhost:8080/user/getall
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getjson") // localhost:8080/user/getjson
    public UserSignUp getUserJson() {
        return new UserSignUp();
    }

    @GetMapping("/login/{username}/{password}") // localhost:8080/user/login/{username}/{password}
    public String login(@PathVariable String username, @PathVariable String password) {
        boolean flag = userCredentialService.validate(username, password);
        return flag ? userService.getUserByUserName(username) : "Enter valid user name and password";

    }
    @GetMapping("/getbyid/{id}") // localhost:8080/user/getbyid
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getbyname/{name}") // localhost:8080/user/getbyname
    public User getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @PutMapping("/updatebyid/{id}") // localhost:8080/user/updatebyid/{id}
    public User updateUserById(@PathVariable int id, @RequestBody User newUser) {
        return userService.updateUserById(id, newUser);
    }

//    public User updateUserByName() {
//      userService
//    }

    @DeleteMapping("/deletebyid/{id}") // localhost:8080/user/deletebyid
    public String deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return "User deleted!!";
    }
}
