package com.example.BookMyShow.Controller;

import com.example.BookMyShow.RequestDTO.TheaterDTO;
import com.example.BookMyShow.Services.TheaterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Theater")
public class TheaterController {

    @Autowired
    TheaterServices theaterServices;
    @PostMapping("/addTheater")
    public ResponseEntity<String> addTheater(@RequestBody()TheaterDTO theaterDTO){
        theaterServices.addTheater(theaterDTO);
        System.out.println(theaterDTO.getNoOfPremiumSeats());

        return new ResponseEntity<>("added Successfully", HttpStatus.CREATED);
    }
}
