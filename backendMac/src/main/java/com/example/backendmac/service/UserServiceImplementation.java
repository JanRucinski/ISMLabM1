package com.example.com_rucinski.service;

import com.example.com_rucinski.repository.UserRepository;
import com.example.com_rucinski.model.User;
import com.example.model.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO signInUser(UserDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.getEmail());
        if (user != null && user.getPassword().equals(userDTO.getPassword())) {
            return convertToDTO(user);
        }
        return null;
    }

    @Override
    public UserDTO signUpUser(UserDTO userDTO) {
        User existingUser = userRepository.findByEmail(userDTO.getEmail());
        if (existingUser == null) {
            User user = convertToEntity(userDTO);
            User savedUser = userRepository.save(user);
            return convertToDTO(savedUser);
        }
        return null; // User already exists
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }
}
