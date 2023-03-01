package com.example.BookMyShow.Services;

import com.example.BookMyShow.Converter.ShowsConverter;
import com.example.BookMyShow.Entities.*;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Repositries.MovieRepository;
import com.example.BookMyShow.Repositries.ShowsRepository;
import com.example.BookMyShow.Repositries.ShowsSeatRepository;
import com.example.BookMyShow.Repositries.TheaterRepository;
import com.example.BookMyShow.RequestDTO.ShowsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ShowsService {

    @Autowired
    ShowsRepository showsRepository;

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    ShowsSeatRepository showsSeatRepository;

    public void addShows(ShowsDTO showsDTO){
        ShowsEntity showsEntity = ShowsConverter.convert(showsDTO);
        MovieEntity movieEntity = movieRepository.findByname(showsDTO.getMovieName());
        TheaterEntity theaterEntity = theaterRepository.findById(showsDTO.getTheaterId()).get();

        showsEntity.setMovieEntity(movieEntity);
        showsEntity.setTheater(theaterEntity);

        List<ShowSeat> listOfShowSeats = addShowSeats(showsEntity,showsDTO);
        showsEntity.setListOfSeat(listOfShowSeats);

        List<ShowsEntity> movieList = movieEntity.getListOfShow();
        movieList.add(showsEntity);
        movieRepository.save(movieEntity);

        List<ShowsEntity> theaterList = theaterEntity.getListOfShows();
        theaterList.add(showsEntity);
        theaterRepository.save(theaterEntity);

        showsRepository.save(showsEntity);




    }
    public List<ShowSeat> addShowSeats(ShowsEntity showsEntity,ShowsDTO showsDTO){
        List<ShowSeat> listOfShowSeat = new ArrayList<>();
        TheaterEntity theater = theaterRepository.findById(showsDTO.getTheaterId()).get();
        List<TheaterSeat> listOfTheaterSeat = theater.getListOfSeat();
        for(TheaterSeat ts: listOfTheaterSeat){
            ShowSeat ss = new ShowSeat();
            ss.setSeatNo(ts.getSeatNo());
            ss.setSeatType(ts.getSeatType());
            if(ts.getSeatType().equals(SeatType.CLASSIC)){
                ss.setPrice(showsDTO.getPriceOfClassicSeat());
            }
            else{
                ss.setPrice(showsDTO.getPriceOfPremiumSeat());
            }
            ss.setShowsEntity(showsEntity);
            listOfShowSeat.add(ss);
        }
        showsSeatRepository.saveAll(listOfShowSeat);
        return listOfShowSeat;
    }
}
