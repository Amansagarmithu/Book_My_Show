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
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    TheaterSeatRepository theaterSeatsRepository;

    public String addTheater(TheaterDTO theaterDTO){
        TheaterEntity t = TheaterConverter.convert(theaterDTO);
        List<TheaterSeat> listOfSeats = addTheaterSeats(theaterDTO,t);
        t.setListOfSeat(listOfSeats);
        theaterRepository.save(t);
        return t.getName();
    }
    public List<TheaterSeat> addTheaterSeats(TheaterDTO theaterDTO,TheaterEntity t){
        List<TheaterSeat> ans = new ArrayList<>();
        for(int i = 1;i<=theaterDTO.getNoOfClassicSeats();i++){
            TheaterSeat ts = TheaterSeat.builder().seatNo(String.valueOf(i+"C")).seatType(SeatType.CLASSIC).build();
            ans.add(ts);
        }
        for(int i = 1;i<=theaterDTO.getNoOfPremiumSeats();i++){
            TheaterSeat ts = TheaterSeat.builder().seatNo(String.valueOf(i+"P")).seatType(SeatType.PREMIUM).build();
        }
        theaterSeatsRepository.saveAll(ans);
        return ans;
    }
}
