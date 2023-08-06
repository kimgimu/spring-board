package com.kinu.board.boardProject.service;

import com.kinu.board.boardProject.dto.ArticleForm;
import com.kinu.board.boardProject.entity.Article;
import com.kinu.board.boardProject.repository.ArticleRepository;
import com.kinu.board.boardProject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepo;

    @Autowired
    CommentRepository commentRepo;

    public int create(ArticleForm dto){
        int check = 0;
        Article article = dto.toEntity();

        if(article.getId() != null){
            article.setId(null);
        }

        Article saved = articleRepo.save(article);
        if(saved != null){
            check = 1;
        }else {
            check = -1;
        }
        return check;
    }

    public Article showPost(Long id){
        Article article = articleRepo.findById(id).orElse(null);
        return article;
    }

    public List<Article> showList(){
        return articleRepo.findAll();
    }

    @Transactional
    public int deleteArticle(Long id){

        int allCheck = 0;
        return allCheck;
    }

}
