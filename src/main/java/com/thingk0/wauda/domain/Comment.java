package com.thingk0.wauda.domain;

import com.thingk0.wauda.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "party")
    private Party party;

    private String content;
}
