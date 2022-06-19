package com.farukkavlak.hw2.Dao;

import com.farukkavlak.hw2.Model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends JpaRepository<City,Integer> {

    City findByPlateNo(int PlateNo);
}