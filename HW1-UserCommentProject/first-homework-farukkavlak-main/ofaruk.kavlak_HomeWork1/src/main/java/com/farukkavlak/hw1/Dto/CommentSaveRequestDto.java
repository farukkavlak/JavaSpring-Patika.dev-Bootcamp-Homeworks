package com.farukkavlak.hw1.Dto;

import lombok.Data;

import java.util.Date;
//CommentSaveRequestDto to get infos for save Comment
@Data
public class CommentSaveRequestDto {
    private String commentText;
    private Date commentDate;
    private Long productId;
}
