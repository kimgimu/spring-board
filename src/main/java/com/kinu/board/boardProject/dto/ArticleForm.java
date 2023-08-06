package com.kinu.board.boardProject.dto;

import com.kinu.board.boardProject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleForm {

    private Long id;
    private String title;
    private String content;

    public Article toEntity(){
        return new Article(id,title,content);
    }
}
