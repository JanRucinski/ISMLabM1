package com.murad.sh.carbootsale.service;


import com.murad.sh.model.SignInUser200Response;
import com.murad.sh.model.SignInUserRequest;
import com.murad.sh.model.SignUpUser201Response;
import com.murad.sh.model.SignUpUserRequest;

public interface UserService {
     SignInUser200Response signInUser(SignInUserRequest request);
     SignUpUser201Response signUpUser(SignUpUserRequest request);
}
