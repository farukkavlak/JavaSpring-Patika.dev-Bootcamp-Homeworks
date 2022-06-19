package com.farukkavlak.hw2.Dao;

import com.farukkavlak.hw2.Model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictDao extends JpaRepository<District,Integer> {

    District findByName(String districtName);
}
