package com.example.BookMyShow.Entities;

import com.example.BookMyShow.Enums.ShowType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ShowsEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;


    private LocalDate showDate;


    private LocalTime showTiming;

    @Enumerated(value = EnumType.STRING)
    private ShowType showType;

    @OneToMany(mappedBy = "showsEntity",cascade = CascadeType.ALL)
    List<TicketEntity> listOfTickets = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private MovieEntity movieEntity;

    @OneToMany(mappedBy = "showsEntity",cascade = CascadeType.ALL)
    List<ShowSeat> listOfSeat = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private TheaterEntity theater;
}
