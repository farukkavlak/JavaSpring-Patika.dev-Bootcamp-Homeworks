package com.farukkavlak.hw2.Dao;

import com.farukkavlak.hw2.Model.Neighbourhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeighbourhoodDao extends JpaRepository<Neighbourhood,Integer> {

    Neighbourhood findByName(String neighbourhoodName);
}
