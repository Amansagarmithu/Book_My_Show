package com.example.BookMyShow.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "UserEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String email;

    private int age;

    @Column(unique = true)
    private String address;

    @Column(unique = true)
    private String mobileno;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<TicketEntity> listOfTickets = new ArrayList<>();
}
