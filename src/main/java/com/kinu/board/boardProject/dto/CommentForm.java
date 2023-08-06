package com.kinu.board.boardProject.dto;

import com.kinu.board.boardProject.entity.Article;
import com.kinu.board.boardProject.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentForm {

    private Long id;
    private String body;
    private String nickname;
    private Long articleId;

    public Comment toEntity(){
        Article article = new Article();
        article.setId(articleId);
        return new Comment(id,body,nickname,article);
    }

}
