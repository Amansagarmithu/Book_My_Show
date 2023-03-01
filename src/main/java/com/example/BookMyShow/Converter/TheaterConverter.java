package com.example.BookMyShow.Converter;

import com.example.BookMyShow.Entities.TheaterEntity;
import com.example.BookMyShow.RequestDTO.TheaterDTO;

public class TheaterConverter {

    public static TheaterEntity convert(TheaterDTO theaterDTO){
        TheaterEntity th = TheaterEntity.builder().name(theaterDTO.getName()).location(theaterDTO.getLocation()).build();
        return th;
    }
}
