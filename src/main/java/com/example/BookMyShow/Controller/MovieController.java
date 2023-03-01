package com.example.BookMyShow.Controller;

import com.example.BookMyShow.RequestDTO.MovieDTO;
import com.example.BookMyShow.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity<String> addMovie(@RequestBody MovieDTO movieDTO){
        return new ResponseEntity<>(movieService.addMovie(movieDTO), HttpStatus.OK);
    }
}
