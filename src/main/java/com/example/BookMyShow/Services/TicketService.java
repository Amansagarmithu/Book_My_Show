package com.example.BookMyShow.Services;

import com.example.BookMyShow.Entities.*;
import com.example.BookMyShow.Repositries.*;
import com.example.BookMyShow.RequestDTO.TicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ShowsRepository showsRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShowsSeatRepository showsSeatRepository;

    public String bookTicket(TicketDTO ticketDTO)throws Exception{

        ShowsEntity showsEntity = showsRepository.findById(ticketDTO.getShowsId()).get();

        MovieEntity movieEntity = showsEntity.getMovieEntity();

        TheaterEntity theaterEntity = showsEntity.getTheater();

        TicketEntity ticketEntity = new TicketEntity();
        boolean validation = cheackSeatAvailablity(ticketDTO.getSeatNo(),showsEntity);

        if(validation==false) throw new Exception("Chossen Seats are not available");

        ticketEntity.setMoviename(movieEntity.getName());
        ticketEntity.setShowsDate(showsEntity.getShowDate());
        ticketEntity.setShowsTiming(showsEntity.getShowTiming());
        ticketEntity.setTheaterName(theaterEntity.getName());
        ticketEntity.setShowsEntity(showsEntity);
        ticketEntity.setUser(userRepository.findById(ticketDTO.getUserID()).get());
        ticketEntity.setPrice(Pricing(ticketDTO.getSeatNo(),showsEntity));

        String bookedSeats = "";
        for(String s:ticketDTO.getSeatNo()){
            bookedSeats+=(s+", ");
        }
        ticketEntity.setSeatNumbers(bookedSeats);

        List<TicketEntity> listOfTicket = showsEntity.getListOfTickets();
        listOfTicket.add(ticketEntity);
        showsEntity.setListOfTickets(listOfTicket);
        showsRepository.save(showsEntity);

        ticketRepository.save(ticketEntity);

        return "Successfully Booked";

    }
    private int Pricing(List<String> requestedSeat,ShowsEntity showsEntity){
        List<ShowSeat> listOfSeats = showsEntity.getListOfSeat();
        int price =  0;
        for(ShowSeat ss: listOfSeats){
            if(requestedSeat.contains(ss.getSeatNo())){
                price+=ss.getPrice();
                ss.setBooked(true);
                showsSeatRepository.save(ss);
            }
        }
        return price;
    }
    private boolean cheackSeatAvailablity(List<String> requestedSeat,ShowsEntity showsEntity){
        List<ShowSeat> listOfSeats = showsEntity.getListOfSeat();
        for(ShowSeat ss: listOfSeats){
            if(requestedSeat.contains(ss.getSeatNo())){
                if(ss.isBooked()){
                    return false;
                }
            }
        }
        return true;
    }
}
