package com.kinu.board.boardProject.repository;

import com.kinu.board.boardProject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query(value = "select * from comment where article_id =:articleId"
            ,nativeQuery = true)
    List<Comment> findByArticleId(Long articleId);



}
