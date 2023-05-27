package com.thingk0.wauda.domain;

import com.thingk0.wauda.domain.base.BaseEntity;
import com.thingk0.wauda.domain.constant.Category;
import com.thingk0.wauda.domain.constant.PartyStatus;
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

    @OneToOne
    @JoinColumn(name = "party_owner")
    private Member owner;

    @Column(name = "party_member_count")
    private int count;

}
