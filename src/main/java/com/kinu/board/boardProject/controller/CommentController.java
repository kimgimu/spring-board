package com.kinu.board.boardProject.controller;

import com.kinu.board.boardProject.dto.CommentForm;
import com.kinu.board.boardProject.entity.Comment;
import com.kinu.board.boardProject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    //댓글 작성
    @PostMapping("/comment/create")
    public ResponseEntity<Integer> create(@RequestBody CommentForm comment){
        int check = commentService.create(comment);
        return check == 1 ? ResponseEntity.ok(check) :
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(check);
    }

    @GetMapping("/comment/show/{id}")
    public ResponseEntity<List<Comment>> commentList (@PathVariable Long id){
        List<Comment> commentList = commentService.commentList(id);
        return commentList != null ? ResponseEntity.ok(commentList)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(commentList);
    }

}
