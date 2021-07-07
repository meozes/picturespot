package com.sparta.hanghae.picturespot.repository;

import com.sparta.hanghae.picturespot.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByUserIdOrderByModifiedDesc(Long userId);

    Optional<Board> findByIdOrderByModifiedDesc(Long boardId);

    List<Board> findByTitleContainingOrContentContainingOrderByModifiedDesc(String title, String content);

    List<Board> findAllByOrderByModifiedDesc();

    //Page<Board> findByIdLessThanAndUserIdOrderByModifiedDesc(Long lastId, Long userId, Pageable pageable);

    @EntityGraph
    Slice<Board> findByIdLessThanAndUserIdOrderByModifiedDesc(Long lastId, Long userId, Pageable pageable);

    @EntityGraph(attributePaths = {"comments","comments.user"})
    List<Board> findAllEntityGraphWithUserByIdLessThanOrderByIdDesc(Long lastBoardId, PageRequest request);

    @Query("select a from Board a join fetch a.comments s")
    List<Board> findAllJoinFetch();



//    Page<Board> findAll(Pageable pageRequest);
//
//    @Query("select a from Board a left join fetch a.comments s")
//    List<Board> findAllJoinFetch();
//
//
//    @Query("SELECT distinct b " +
//            "FROM Board b " +
//            "left JOIN FETCH b.comments " +
//            "left JOIN FETCH b.boardImgUrls " +
//            "left JOIN fetch b.hearts")
//    List<Board> findByIdLessThan(Long lastBoardId);
//
//
    @Query("SELECT distinct b " +
              "FROM Board b " +
              "left JOIN FETCH b.boardImgUrls " +
              "left JOIN fetch b.hearts")
    List<Board> findAllFetchJoin();
//
//
//    Page<Board> findByIdInOrderByIdDesc(List<Board> ac, Pageable pageRequest);
//
    List<Board> findByIdLessThanOrderByIdDesc(Long lastBoardId, Pageable pageable);

    @Query("SELECT distinct b " +
            "FROM Board b " +
            "left JOIN FETCH b.comments " +
            "left JOIN FETCH b.boardImgUrls " +
            "left JOIN fetch b.hearts")
    List<Board> findAllFetchJoinOrderByModifiedDesc();


//    @Query(value = "SELECT b" +
//            " FROM Board b" +
//            " LEFT JOIN Follow f" +
//            " ON p.member.id = f.toMember.id" +
//            " WHERE f.fromMember.id = :memberId AND p.id < :lastPostId")
//    List<Board> findByIdLessThanAndUserInOrderByIdDesc(long lastId, List<User> collect, Pageable pageRequest);

}

