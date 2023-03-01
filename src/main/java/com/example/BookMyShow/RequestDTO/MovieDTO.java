package com.example.BookMyShow.RequestDTO;

import com.example.BookMyShow.Enums.Genre;
import com.example.BookMyShow.Enums.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private String name;

    private double rating;

    private int duration;

    private Language language;

    private Genre genre;
}
