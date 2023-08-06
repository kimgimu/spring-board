package com.kinu.board.boardProject.service;

import com.kinu.board.boardProject.dto.CommentForm;
import com.kinu.board.boardProject.entity.Comment;
import com.kinu.board.boardProject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepo;

    public  int create(CommentForm dto){
        int check = 0;
        Comment comment = dto.toEntity();
        Comment saved = null;
        if(comment.getArticle().getId() != null){
            saved = commentRepo.save(comment);
        }
        if(saved != null){
            check = 1;
        }else {
            check = -1;
        }
        return check;
    }

    public List<Comment> commentList(Long articleId){
        List commentList = commentRepo.findByArticleId(articleId);
        return  commentList;
    }

}
