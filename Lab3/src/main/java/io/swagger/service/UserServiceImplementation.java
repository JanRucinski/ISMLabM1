package io.swagger.service;

import io.swagger.model.InlineResponse200;
import io.swagger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.swagger.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepository;

    public InlineResponse200 loginUser(String email, String password){
        return null;
    }
    public InlineResponse200 logoutUser(){
        return null;
    }
    public InlineResponse200 createUser(String email, String password){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return null;
    }
}
