package com.example.BookMyShow.Converter;

import com.example.BookMyShow.Entities.UserEntity;
import com.example.BookMyShow.RequestDTO.UserDTO;

public class UserConverter {

    public static UserEntity convert(UserDTO userDTO){
        UserEntity ur = UserEntity.builder().age(userDTO.getAge()).name(userDTO.getName()).email(userDTO.getEmail()).address(userDTO.getAddress()).mobileno(userDTO.getMobile()).build();
        return ur;
    }
}
