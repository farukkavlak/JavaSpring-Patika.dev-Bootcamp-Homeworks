package com.farukkavlak.hw2.Dao;

import com.farukkavlak.hw2.Model.Address;
import com.farukkavlak.hw2.Model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address,Integer> {

}