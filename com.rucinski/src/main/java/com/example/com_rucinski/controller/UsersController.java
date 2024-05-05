package com.murad.sh.carbootsale.controller;

import com.murad.sh.api.UserAuthenticationApi;
import com.murad.sh.model.SignInUser200Response;
import com.murad.sh.model.SignInUserRequest;
import com.murad.sh.model.SignUpUser201Response;
import com.murad.sh.model.SignUpUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.murad.sh.carbootsale.service.UserService;

@RestController
public class UsersController implements UserAuthenticationApi {

    @Autowired
    private UserService userService;


    @Override
    public ResponseEntity<SignInUser200Response> signInUser(SignInUserRequest signInUserRequest) {
        return new ResponseEntity<>(userService.signInUser(signInUserRequest), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SignUpUser201Response> signUpUser(SignUpUserRequest signUpUserRequest) {
        return new ResponseEntity<>(userService.signUpUser(signUpUserRequest), HttpStatus.OK);
    }

    
}
