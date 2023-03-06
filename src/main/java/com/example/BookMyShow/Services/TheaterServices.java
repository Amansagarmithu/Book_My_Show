package com.example.BookMyShow.Services;

import com.example.BookMyShow.Converter.TheaterConverter;
import com.example.BookMyShow.Entities.TheaterEntity;
import com.example.BookMyShow.Entities.TheaterSeat;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Repositries.TheaterRepository;
import com.example.BookMyShow.Repositries.TheaterSeatRepository;
import com.example.BookMyShow.RequestDTO.TheaterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterServices {

    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    public void addTheater(TheaterDTO theaterDTO){
        TheaterEntity th = TheaterConverter.convert(theaterDTO);
        System.out.println("added");
        System.out.println(theaterDTO.getNoOfClassicSeats());
        System.out.println(theaterDTO.getName());
        System.out.println(theaterDTO.getLocation());
        List<TheaterSeat> listOfSeats = addTheaterSeats(theaterDTO,th);
        th.setListOfSeat(listOfSeats);
        for(TheaterSeat t:listOfSeats){
            System.out.println(t.getSeatNo());
        }
        theaterRepository.save(th);
    }
    public List<TheaterSeat> addTheaterSeats(TheaterDTO theaterDTO,TheaterEntity th){
        List<TheaterSeat> listOfTheaterSeats = new ArrayList<>();
        System.out.println("Inside the function");
        System.out.println(theaterDTO.getNoOfClassicSeats());
        int n = Integer.valueOf(theaterDTO.getNoOfClassicSeats());
        for(int i = 1;i<=n;i++){
            TheaterSeat ts = TheaterSeat.builder().seatNo(i+"C").seatType(SeatType.CLASSIC).theater(th).build();
            System.out.println("Inside the loop ans theater seat no is :-"+ts.getSeatNo());

            listOfTheaterSeats.add(ts);

        }
        int m = Integer.valueOf(theaterDTO.getNoOfPremiumSeats());
        for(int i = 1;i<=m;i++){
            TheaterSeat ts = TheaterSeat.builder().seatNo(i+"P").seatType(SeatType.PREMIUM).theater(th).build();

            listOfTheaterSeats.add(ts);

        }
        theaterSeatRepository.saveAll(listOfTheaterSeats);
        return listOfTheaterSeats;
    }
}
