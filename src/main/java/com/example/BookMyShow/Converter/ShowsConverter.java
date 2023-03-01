package com.example.BookMyShow.Converter;

import com.example.BookMyShow.Entities.ShowsEntity;
import com.example.BookMyShow.RequestDTO.ShowsDTO;

public class ShowsConverter {

    public static ShowsEntity convert(ShowsDTO showsDTO){
        ShowsEntity showsEntity = ShowsEntity.builder().showDate(showsDTO.getShowDate()).showTiming(showsDTO.getShowTime())
                .showType(showsDTO.getShowType()).build();
        return showsEntity;
    }
}
