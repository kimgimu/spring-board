package com.kinu.board.boardProject.controller;

import com.kinu.board.boardProject.dto.ArticleForm;
import com.kinu.board.boardProject.entity.Article;
import com.kinu.board.boardProject.service.ArticleService;
import com.kinu.board.boardProject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    //게시글 작성 (create)
    @PostMapping("/article/create")
    public String create(ArticleForm dto, Model model){
        int check = articleService.create(dto);
        model.addAttribute("check",check);
        return "article";
    }

    //게시글 조회 (read)
    @GetMapping("/article/{id}")
    public String showPost(@PathVariable Long id, Model model){
        Article article = articleService.showPost(id);
        if(article != null){
            model.addAttribute("article",article);
        }
        return "article";
    }

    @GetMapping("/article")
    public String article(){
        return "article";
    }

    //게시판
    @GetMapping("/articles")
    public String board(Model model){
        List<Article> boardList = articleService.showList();
        model.addAttribute("BoardList",boardList);
        System.out.println(boardList);
        return "articles";
    }

    @GetMapping("/home")
    public  String home(){
        return "static/home";
    }

    @PostMapping("/article/delete/{id}")
    public String deleteArticle(@PathVariable Long id){
        int check = articleService.deleteArticle(id);
        if(check == 1){
            return "redirect:articles";
        }
        return "redirect:articles";

    }


}
