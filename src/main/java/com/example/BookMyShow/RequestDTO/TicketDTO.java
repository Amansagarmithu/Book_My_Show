package com.example.BookMyShow.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {

    private int userID;

    private List<String> seatNo;

    private int showsId;

}
