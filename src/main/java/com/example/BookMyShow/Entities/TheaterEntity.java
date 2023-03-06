package com.example.BookMyShow.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String location;
    @JsonIgnore
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    List<ShowsEntity> listOfShows = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    List<TheaterSeat> listOfSeat = new ArrayList<>();
}
