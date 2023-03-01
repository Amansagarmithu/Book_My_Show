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
        List<TheaterSeat> listOfSeats = addTheaterSeats(theaterDTO,th);
        th.setListOfSeat(listOfSeats);
        theaterRepository.save(th);
    }
    public List<TheaterSeat> addTheaterSeats(TheaterDTO theaterDTO,TheaterEntity th){
        List<TheaterSeat> listOfTheaterSeats = new ArrayList<>();
        for(int i = 1;i<=theaterDTO.getNoOfClassicSeats();i++){
            TheaterSeat ts = TheaterSeat.builder().seatNo(String.valueOf(i+"C")).seatType(SeatType.CLASSIC).build();
            listOfTheaterSeats.add(ts);
            ts.setTheater(th);
        }
        for(int i = 1;i<= theaterDTO.getNoOfPremiumSeats();i++){
            TheaterSeat ts = TheaterSeat.builder().seatNo(String.valueOf(i+"P")).seatType(SeatType.PREMIUM).build();
            listOfTheaterSeats.add(ts);
            ts.setTheater(th);
        }
        theaterSeatRepository.saveAll(listOfTheaterSeats);
        return listOfTheaterSeats;
    }
}
