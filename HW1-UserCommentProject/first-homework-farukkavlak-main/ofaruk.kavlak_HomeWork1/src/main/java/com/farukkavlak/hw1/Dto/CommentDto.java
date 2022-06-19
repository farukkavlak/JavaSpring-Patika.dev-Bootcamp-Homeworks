package com.farukkavlak.hw1.Dto;

import com.farukkavlak.hw1.Models.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

//Dto for comment to show user info about Comment Entity
@Data
public class CommentDto {
    private Integer id;
    private String commentText;
    private Date commentDate;
    private Long productId;
    public User user;
}
