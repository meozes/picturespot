package com.sparta.hanghae.picturespot.repository;

import com.sparta.hanghae.picturespot.model.BoardImgUrls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BoardImgUrlsRepository extends JpaRepository<BoardImgUrls, Long> {
    Set<BoardImgUrls> findAllByBoardId(Long boardId);
    //List<BoardImgUrls> findAllByBoardId(Long boardId);

}
