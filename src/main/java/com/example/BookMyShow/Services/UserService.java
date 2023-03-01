package com.example.BookMyShow.Services;

import com.example.BookMyShow.Converter.UserConverter;
import com.example.BookMyShow.Entities.UserEntity;
import com.example.BookMyShow.Repositries.UserRepository;
import com.example.BookMyShow.RequestDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserDTO userDTO){
        UserEntity ur = UserConverter.convert(userDTO);
        userRepository.save(ur);
        return "successfully added";
    }
}
