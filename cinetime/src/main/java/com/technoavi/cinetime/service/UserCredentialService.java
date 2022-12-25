package com.technoavi.cinetime.service;

import com.technoavi.cinetime.dao.model.UserCredential;
import com.technoavi.cinetime.dao.repositories.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class UserCredentialService {
    @Autowired
    UserCredentialRepository userCredentialRepository;

    @Autowired
    UserCredential userCredential;
    public UserCredential createUserCredential(UserCredential userCredential) {
        return userCredentialRepository.save(userCredential);
    }

    public List<UserCredential> getAllUserCredentials() {
        return userCredentialRepository.findAll();
    }

    public UserCredential getUserCredentialJson() {
        return new UserCredential();
    }
    public UserCredential getUserCredentialById(int id) {
        return userCredentialRepository.findById(id).get();
    }

    public UserCredential getUserCredentialByName(String name) {
        return userCredentialRepository.findByName(name);
    }

    private UserCredential copyUserCredential(UserCredential oldUserCredential, UserCredential newUserCredential) {
        oldUserCredential.setName(newUserCredential.getName());
        oldUserCredential.setUserId(newUserCredential.getUserId());
        oldUserCredential.setPassword(newUserCredential.getPassword());
        return oldUserCredential;
    }

    public UserCredential updateUserCredentialById(int id, UserCredential newUserCredential) {
        UserCredential oldUserCredential = userCredentialRepository.findById(id).get();
        return userCredentialRepository.save(copyUserCredential(oldUserCredential, newUserCredential));
    }

//    public UserCredential updateUserCredentialByName() {
//      userCredentialRepository
//    }

    public String deleteUserCredentialById(int id) {
        userCredentialRepository.deleteById(id);
        return "UserCredential deleted!!";
    }

    public static String decode(String encodedPassword) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(encodedPassword);

        return new String(bytes);
    }
    public boolean validate(String username, String password) {

        UserCredential userCredential = userCredentialRepository.findByUserName(username);
        return (userCredential != null) ? decode(userCredential.getPassword()).equals(password) : false;
    }
}
