package com.example.BookMyShow.Repositries;

import com.example.BookMyShow.Entities.ShowsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowsRepository extends JpaRepository<ShowsEntity,Integer> {
}
