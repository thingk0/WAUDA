package com.thingk0.wauda.domain;

import com.thingk0.wauda.domain.base.BaseEntity;
import com.thingk0.wauda.dto.comments.CommentsForm;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name = "comments")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comments extends BaseEntity {

    @Id
    @Column(name = "comments_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "member")
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "party")
    private Party party;

    @Column(nullable = false, length = 100)
    private String content;


    public static Comments createComments(CommentsForm commentsForm, Member member, Party party) {
        return Comments.builder()
                .member(member)
                .party(party)
                .content(commentsForm.getComment())
                .build();
    }

}
