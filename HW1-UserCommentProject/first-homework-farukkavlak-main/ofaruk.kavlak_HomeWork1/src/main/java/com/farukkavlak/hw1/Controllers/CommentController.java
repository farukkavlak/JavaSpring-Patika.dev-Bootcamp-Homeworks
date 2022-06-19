package com.farukkavlak.hw1.Controllers;

import com.farukkavlak.hw1.Converter.CommentConverter;
import com.farukkavlak.hw1.Dto.CommentDto;
import com.farukkavlak.hw1.Dto.CommentSaveRequestDto;
import com.farukkavlak.hw1.Models.Comment;
import com.farukkavlak.hw1.Models.User;
import com.farukkavlak.hw1.Repositories.CommentRepository;
import com.farukkavlak.hw1.Repositories.UserRepository;
import com.farukkavlak.hw1.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //To save comment with given CommentSaveRequestDto
    @PostMapping("saveComment/{commentedUser_id}")
    public ResponseEntity saveComment(@RequestBody CommentSaveRequestDto commentSaveRequestDto, @PathVariable("commentedUser_id") int commentedUser_id){
        commentService.saveComment(commentSaveRequestDto,commentedUser_id);
        return new ResponseEntity(commentSaveRequestDto, HttpStatus.CREATED);
    }

    //To find all comments
    @GetMapping("findAll")
    public ResponseEntity findAll(){
        List<CommentDto> commentListDto = commentService.findAll();
        return ResponseEntity.ok(commentListDto);
    }

    //To delete comment with given id
    @DeleteMapping("deleteById/{deletedComment_id}")
    public ResponseEntity deleteCommentById(@PathVariable("deletedComment_id") int deletedComment_id){
        commentService.deleteById(deletedComment_id);
        return ResponseEntity.ok().build();
    }

    //To update comment with given id
    @PatchMapping("updateById/{updatedComment_id}")
    public ResponseEntity updateById(@RequestBody String commentText,@PathVariable("updatedComment_id") int updatedComment_id){
        Comment updatedComment = commentService.updateById(commentText,updatedComment_id);
        return ResponseEntity.ok(updatedComment);
    }
}
