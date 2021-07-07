package com.sparta.hanghae.picturespot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Heart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HEART_ID")
    private Long id;

    //@ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    @Builder
    public Heart(User user, Board board) {
        this.user = user;
        this.board = board;
    }
}
