package com.example.BookMyShow.Converter;

import com.example.BookMyShow.Entities.MovieEntity;
import com.example.BookMyShow.RequestDTO.MovieDTO;

public class MovieConverter {

    public static MovieEntity convert(MovieDTO movieDTO){
        MovieEntity movieEntity = MovieEntity.builder().name(movieDTO.getName()).rating(movieDTO.getRating())
                .duration(movieDTO.getDuration()).genre(movieDTO.getGenre()).language(movieDTO.getLanguage()).build();
        return movieEntity;
    }
}
