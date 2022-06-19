package com.farukkavlak.hw2.Dao;

import com.farukkavlak.hw2.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryDao extends JpaRepository<Country,Integer> {

    Country findByCountryCode(int CountryCode);
}
