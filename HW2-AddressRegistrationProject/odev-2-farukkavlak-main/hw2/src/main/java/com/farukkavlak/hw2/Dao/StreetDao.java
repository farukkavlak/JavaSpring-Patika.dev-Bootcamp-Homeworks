package com.farukkavlak.hw2.Dao;

import com.farukkavlak.hw2.Model.Neighbourhood;
import com.farukkavlak.hw2.Model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetDao extends JpaRepository<Street,Integer> {

    Street findByName(String streetName);
}
