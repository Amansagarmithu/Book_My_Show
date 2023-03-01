package com.example.BookMyShow.Repositries;

import com.example.BookMyShow.Entities.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowsSeatRepository extends JpaRepository<ShowSeat,Integer> {
}
