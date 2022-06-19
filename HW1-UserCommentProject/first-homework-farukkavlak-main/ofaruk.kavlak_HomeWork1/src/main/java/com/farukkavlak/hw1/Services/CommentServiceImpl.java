package com.farukkavlak.hw1.Services;

import com.farukkavlak.hw1.Converter.CommentConverter;
import com.farukkavlak.hw1.Dto.CommentDto;
import com.farukkavlak.hw1.Dto.CommentSaveRequestDto;
import com.farukkavlak.hw1.Dto.UserDto;
import com.farukkavlak.hw1.Models.Comment;
import com.farukkavlak.hw1.Models.User;
import com.farukkavlak.hw1.Repositories.CommentRepository;
import com.farukkavlak.hw1.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

    CommentConverter commentConverter = new CommentConverter();

    //Save with given Dto
    @Override
    public CommentDto saveComment(CommentSaveRequestDto commentSaveRequestDto, int commentedUser_id) {
        User commentedUser = userRepository.findById(commentedUser_id).orElseThrow();
        Comment comment = commentConverter.convertToComment(commentSaveRequestDto);
        comment.setUser(commentedUser);
        commentRepository.save(comment);
        CommentDto commentDto = commentConverter.convertToCommentDto(comment);
        return commentDto;
    }

    @Override
    public List<CommentDto> findAll() {
        List<Comment> commentList = commentRepository.findAll();
        List<CommentDto> commentDtoList = commentConverter.convertToCommentDtoList(commentList);
        return commentDtoList;
    }

    //Delete from repo
    @Override
    public void deleteById(int deletedComment_id) {
        boolean isExist = commentRepository.existsById(deletedComment_id);
        if(!isExist){
            throw new RuntimeException("User does not exist with given id.");
        }
        commentRepository.deleteById(deletedComment_id);
    }

    //Update with given text and save again to the Comment repo
    @Override
    public Comment updateById(String commentText, int updatedComment_id) {
        Comment updatedComment = commentRepository.findById(updatedComment_id).orElseThrow();
        updatedComment.setCommentText(commentText);
        commentRepository.save(updatedComment);
        return updatedComment;
    }
}
