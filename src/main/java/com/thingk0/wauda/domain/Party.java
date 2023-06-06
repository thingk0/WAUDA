package com.thingk0.wauda.domain;

import com.thingk0.wauda.domain.base.BaseEntity;
import com.thingk0.wauda.domain.constant.Category;
import com.thingk0.wauda.domain.constant.PartyStatus;
import com.thingk0.wauda.dto.party.PartyForm;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name = "party")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Party extends BaseEntity {

    @Id
    @Column(name = "party_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "party_name")
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private PartyStatus partyStatus;

    @Lob
    private String content;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "party_owner")
    private Member owner;

    @Column(name = "party_member_count")
    private int count;


    public static Party create(PartyForm partyForm, Member member) {
        return Party.builder()
                .name(partyForm.getName())
                .category(partyForm.getCategory())
                .partyStatus(PartyStatus.RECRUITING)
                .content(partyForm.getContent())
                .owner(member)
                .count(partyForm.getMemberCnt())
                .build();
    }

}
