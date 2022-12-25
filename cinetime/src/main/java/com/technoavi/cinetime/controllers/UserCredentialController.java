package com.technoavi.cinetime.controllers;

import com.technoavi.cinetime.dao.model.UserCredential;
import com.technoavi.cinetime.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usercredential") // localhost:8080/usercredential
public class UserCredentialController {
    @Autowired
    UserCredentialService userCredentialService;

    @PostMapping("/save") // localhost:8080/usercredential/save
    public UserCredential createUserCredential(@RequestBody UserCredential userCredential) {
        return userCredentialService.createUserCredential(userCredential);
    }

    @GetMapping("/getall") // localhost:8080/usercredential/getall
    public List<UserCredential> getAllUserCredentials() {
        return userCredentialService.getAllUserCredentials();
    }

    @GetMapping("/getjson") // localhost:8080/usercredential/getjson
    public UserCredential getUserCredentialJson() {
        return new UserCredential();
    }

    @GetMapping("/getbyid/{id}") // localhost:8080/usercredential/getbyid
    public UserCredential getUserCredentialById(@PathVariable int id) {
        return userCredentialService.getUserCredentialById(id);
    }

    @GetMapping("/getbyname/{name}") // localhost:8080/usercredential/getbyname
    public UserCredential getUserCredentialByName(@PathVariable String name) {
        return userCredentialService.getUserCredentialByName(name);
    }

    @PutMapping("/updatebyid/{id}") // localhost:8080/usercredential/updatebyid/{id}
    public UserCredential updateUserCredentialById(@PathVariable int id, @RequestBody UserCredential newUserCredential) {
        return userCredentialService.updateUserCredentialById(id, newUserCredential);
    }

//    public UserCredential updateUserCredentialByName() {
//      userCredentialService
//    }

    @DeleteMapping("/deletebyid/{id}") // localhost:8080/usercredential/deletebyid
    public String deleteUserCredentialById(@PathVariable int id) {
        userCredentialService.deleteUserCredentialById(id);
        return "UserCredential deleted!!";
    }
}
