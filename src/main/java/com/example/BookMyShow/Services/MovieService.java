package com.example.BookMyShow.Services;

import com.example.BookMyShow.Converter.MovieConverter;
import com.example.BookMyShow.Entities.MovieEntity;
import com.example.BookMyShow.Repositries.MovieRepository;
import com.example.BookMyShow.RequestDTO.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;


    public String addMovie(MovieDTO movieDTO){
        MovieEntity movieEntity = MovieConverter.convert(movieDTO);
        movieRepository.save(movieEntity);
        return "added Successfully";
    }
}
