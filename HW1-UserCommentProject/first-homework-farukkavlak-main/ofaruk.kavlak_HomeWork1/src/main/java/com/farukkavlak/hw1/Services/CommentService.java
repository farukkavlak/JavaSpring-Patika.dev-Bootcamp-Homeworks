package com.farukkavlak.hw1.Services;

import com.farukkavlak.hw1.Dto.CommentDto;
import com.farukkavlak.hw1.Dto.CommentSaveRequestDto;
import com.farukkavlak.hw1.Models.Comment;

import java.util.List;
//Interface to do some operations on the Comment Entity
public interface CommentService {
    CommentDto saveComment(CommentSaveRequestDto commentSaveRequestDto, int commentedUser_id);
    List<CommentDto> findAll();
    void deleteById(int deletedComment_id);
    Comment updateById(String commentText,int updatedComment_id);
}
