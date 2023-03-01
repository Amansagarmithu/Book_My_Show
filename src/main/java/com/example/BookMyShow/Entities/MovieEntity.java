package com.example.BookMyShow.Entities;

import com.example.BookMyShow.Enums.Genre;
import com.example.BookMyShow.Enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MovieEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(unique = true)
    private String name;

    private double rating;

    private int duration;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "movieEntity",cascade = CascadeType.ALL)
    List<ShowsEntity> listOfShow = new ArrayList<>();
}
