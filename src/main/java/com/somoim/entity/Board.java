package com.somoim.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(name = "comment")
    private String comment;

    @JsonIgnore
    @OneToOne(mappedBy = "board", fetch = FetchType.LAZY)
    private Meeting meeting;

    // TODO 사진첩, 채팅
}
