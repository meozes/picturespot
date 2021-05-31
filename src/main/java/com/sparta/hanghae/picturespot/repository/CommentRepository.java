package com.sparta.hanghae.picturespot.repository;

import com.sparta.hanghae.picturespot.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBoardId(Long boardId);
    Set<Comment> findAllByBoardIdOrderByModifiedDesc(Long boardId);
}
