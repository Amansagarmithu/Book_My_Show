package com.example.BookMyShow.RequestDTO;

import com.example.BookMyShow.Enums.ShowType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowsDTO {

    private ShowType showType;

    private LocalDate showDate;

    private LocalTime showTime;

    private int priceOfClassicSeat;

    private int priceOfPremiumSeat;

    private String movieName;

    private int theaterId;
}
