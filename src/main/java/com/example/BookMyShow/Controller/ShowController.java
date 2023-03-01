package com.example.BookMyShow.Controller;

import com.example.BookMyShow.RequestDTO.ShowsDTO;
import com.example.BookMyShow.Services.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Shows")
public class ShowController {
    @Autowired
    ShowsService showsService;

    @PostMapping("add_Shows")
    public ResponseEntity<String> addShows(@RequestBody()ShowsDTO showsDTO){
        showsService.addShows(showsDTO);
        return new ResponseEntity<>("Show Added Successfully", HttpStatus.CREATED);
    }
}
