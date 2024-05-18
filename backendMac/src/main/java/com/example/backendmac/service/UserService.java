package com.example.com_rucinski.service;

import com.example.model.UserDTO;
public interface UserService {
     UserDTO signInUser(UserDTO userDTO);
     UserDTO signUpUser(UserDTO userDTO);
}
