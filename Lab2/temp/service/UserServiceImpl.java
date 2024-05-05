package com.example.com_rucinski.service;

import com.murad.sh.carbootsale.model.User;
import com.murad.sh.carbootsale.repository.UserRepository;
import com.murad.sh.model.SignInUser200Response;
import com.murad.sh.model.SignInUserRequest;
import com.murad.sh.model.SignUpUser201Response;
import com.murad.sh.model.SignUpUserRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public SignUpUser201Response signUpUser(SignUpUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        if (request.getRole().getValue().equals("ORGANIZER")) {
            user.setRole(User.Role.ORGANIZER);
        }
        else if (request.getRole().getValue().equals("SELLER")) {
            user.setRole(User.Role.SELLER);
        }
        userRepository.save(user);
        return new SignUpUser201Response().userId(user.getUserId());
    }

    @Override
    public SignInUser200Response signInUser(SignInUserRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user != null && user.getPassword().equals(request.getPassword())) {
            SignInUser200Response response = new SignInUser200Response();
            response.setUserId(user.getUserId());
            response.setAuthToken("authToken");
            return response;
        }
        return null;
    }
}
