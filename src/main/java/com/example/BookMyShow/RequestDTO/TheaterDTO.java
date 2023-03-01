package com.example.BookMyShow.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheaterDTO {

    private String name;

    private String location;

    private int NoOfClassicSeats;

    private int NoOfPremiumSeats;
}
