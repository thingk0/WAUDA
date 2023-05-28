package com.thingk0.wauda;

import com.thingk0.wauda.domain.Member;
import com.thingk0.wauda.domain.Party;
import com.thingk0.wauda.domain.PartyMember;
import com.thingk0.wauda.domain.constant.Category;
import com.thingk0.wauda.domain.constant.PartyStatus;
import com.thingk0.wauda.repository.CommentRepository;
import com.thingk0.wauda.repository.MemberRepository;
import com.thingk0.wauda.repository.PartyMemberRepository;
import com.thingk0.wauda.repository.PartyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class WaudaApplicationTests {

    @PersistenceContext
    EntityManager em;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    PartyMemberRepository partyMemberRepository;

    @Autowired
    CommentRepository commentRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void createMemberTest() {
        // given
        Member member = createMember("Member");

        // when
        Member savedMember = memberRepository.save(member);

        // then
        assertThat(member).isEqualTo(savedMember);
    }

    @Test
    public void createPartyTest() {
        // given
        Member member1 = createMember("Member1");
        Party taxiParty = createParty("TAXI PARTY", member1);

        // when
        em.persist(member1);
        em.persist(taxiParty);

        em.flush();
        em.clear();

        // then
        assertThat(member1).isEqualTo(taxiParty.getOwner());
        assertThat(taxiParty.getName()).isEqualTo("TAXI PARTY");
    }

    @Test
    public void joinPartyMemberTest() {

        // given
        Member member1 = createMember("member1");
        em.persist(member1);
        Member member2 = createMember("member2");
        em.persist(member2);

        Party taxiParty = createParty("TAXI PARTY", member1);
        em.persist(taxiParty);

        PartyMember pm1 = PartyMember.builder()
                .member(member1)
                .party(taxiParty)
                .build();
        em.persist(pm1);

        PartyMember pm2 = PartyMember.builder()
                .member(member2)
                .party(taxiParty)
                .build();
        em.persist(pm2);

        em.flush();
        em.clear();


        // when
        List<PartyMember> all = partyMemberRepository.findAll();


        // then
        assertThat(all.size()).isEqualTo(2);
        assertThat(all.get(0).getParty().getId()).isEqualTo(taxiParty.getId());
    }




    public Party createParty(String partyName, Member member) {
        return Party.builder()
                .name(partyName)
                .category(Category.TAXI)
                .partyStatus(PartyStatus.RECRUITING)
                .content("택시팟 구함!! 선착순 2명")
                .owner(member)
                .build();
    }

    public Member createMember(String name) {
        return Member.builder()
                .email(String.format("%s@naver.com", name))
                .password("1234")
                .nickname(name)
                .build();
    }

}
