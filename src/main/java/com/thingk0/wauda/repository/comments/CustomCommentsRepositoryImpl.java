package com.thingk0.wauda.repository.comments;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.thingk0.wauda.dto.comments.CommentsDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.thingk0.wauda.domain.QComments.comments;
import static com.thingk0.wauda.domain.QMember.member;

@RequiredArgsConstructor
public class CustomCommentsRepositoryImpl implements CustomCommentsRepository {

    private final JPAQueryFactory query;

    @Override
    public List<CommentsDto> commentsList(Long partyId) {
        return query
                .select(Projections.constructor(CommentsDto.class,
                        comments.id,
                        comments.content,
                        member.id,
                        member.nickname,
                        comments.createdAt,
                        comments.modifiedAt))
                .from(comments)
                .leftJoin(comments.member, member)
                .where(comments.party.id.eq(partyId))
                .orderBy(comments.createdAt.desc())
                .fetch();
    }


}
