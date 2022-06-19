package com.farukkavlak.hw1.Converter;

import com.farukkavlak.hw1.Dto.*;
import com.farukkavlak.hw1.Models.Comment;
import com.farukkavlak.hw1.Models.User;

import java.util.ArrayList;
import java.util.List;
//To make some conversions about comment
public class CommentConverter {

    //CommentSaveRequestDto -> Comment Entity
    public Comment convertToComment(CommentSaveRequestDto commentSaveRequestDto){
        Comment comment = new Comment();
        comment.setCommentDate(commentSaveRequestDto.getCommentDate());
        comment.setCommentText(commentSaveRequestDto.getCommentText());
        comment.setProductId(commentSaveRequestDto.getProductId());
        return comment;
    }

    //Comment Entity -> CommentDto
    public CommentDto convertToCommentDto(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setCommentDate(comment.getCommentDate());
        commentDto.setCommentText(comment.getCommentText());
        commentDto.setProductId(comment.getProductId());
        commentDto.setUser(comment.getUser());;
        commentDto.setId(comment.getId());;
        return commentDto;
    }

    //CommentList -> CommentDtoList
    public List<CommentDto> convertToCommentDtoList(List<Comment> commentList){
        List<CommentDto> commentDtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentDto commentDto = convertToCommentDto(comment);
            commentDtoList.add(commentDto);
        }
        return commentDtoList;
    }

}
