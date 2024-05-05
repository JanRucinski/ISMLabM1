package com.example.com_rucinski.controller;

import com.example.api.RegistrationAndAuthenticationApi;
import com.example.com_rucinski.service.UserService;
import com.example.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController implements RegistrationAndAuthenticationApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<Void> usersLoginPost(UserDTO userDTO) {
        boolean loginSuccessful = userService.signInUser(userDTO) != null;
        if (loginSuccessful) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @Override
    public ResponseEntity<Void> usersRegisterPost(UserDTO userDTO) {
        UserDTO registeredUser = userService.signUpUser(userDTO);
        if (registeredUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
