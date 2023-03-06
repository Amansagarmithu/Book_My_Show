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

    private String NoOfClassicSeats;

    private String NoOfPremiumSeats;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNoOfClassicSeats() {
        return NoOfClassicSeats;
    }

    public void setNoOfClassicSeats(String noOfClassicSeats) {
        NoOfClassicSeats = noOfClassicSeats;
    }

    public String getNoOfPremiumSeats() {
        return NoOfPremiumSeats;
    }

    public void setNoOfPremiumSeats(String noOfPremiumSeats) {
        NoOfPremiumSeats = noOfPremiumSeats;
    }
}
