package com.farukkavlak.hw1.Repositories;

import com.farukkavlak.hw1.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//User Dao - Repository
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
