package com.example.BookMyShow.Controller;

import com.example.BookMyShow.RequestDTO.UserDTO;
import com.example.BookMyShow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add_User")
    public ResponseEntity<String> addUser(@RequestBody() UserDTO userDTO){
        return new ResponseEntity<>(userService.addUser(userDTO), HttpStatus.CREATED);
    }
}
