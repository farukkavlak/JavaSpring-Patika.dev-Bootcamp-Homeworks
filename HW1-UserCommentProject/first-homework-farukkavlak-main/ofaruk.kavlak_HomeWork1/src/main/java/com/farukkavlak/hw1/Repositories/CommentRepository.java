package com.farukkavlak.hw1.Repositories;

import com.farukkavlak.hw1.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Comment Dao - Repository
@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
