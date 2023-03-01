package com.example.BookMyShow.Controller;

import com.example.BookMyShow.RequestDTO.TicketDTO;
import com.example.BookMyShow.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping("Book_Ticket")
    public ResponseEntity<String> bookTicket(@RequestBody TicketDTO ticketDTO)throws Exception{
        try{
            return new ResponseEntity<>(ticketService.bookTicket(ticketDTO), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
        }
    }
}
