package com.thingk0.wauda.repository.party;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.thingk0.wauda.dto.party.PartyListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import static com.thingk0.wauda.domain.QParty.party;

@RequiredArgsConstructor
public class CustomPartyRepositoryImpl implements CustomPartyRepository {

    private final JPAQueryFactory query;

    @Override
    public Page<PartyListDto> partyListBySearchCond(String searchCond, Pageable pageable) {

        BooleanBuilder builder = new BooleanBuilder();
        if (searchCond != null && !searchCond.trim().isEmpty()) {
            builder.and(party.name.contains(searchCond));
        }

        QueryResults<PartyListDto> results = query
                .select(Projections.constructor(PartyListDto.class,
                        party.id.as("id"),
                        party.name.as("name"),
                        party.category.as("category"),
                        party.partyStatus.as("partyStatus"),
                        party.count.as("count")))
                .from(party)
                .where(builder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }
}

