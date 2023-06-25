package com.thingk0.wauda.service;

import com.thingk0.wauda.domain.Comments;
import com.thingk0.wauda.domain.Member;
import com.thingk0.wauda.domain.Party;
import com.thingk0.wauda.dto.comments.CommentsDto;
import com.thingk0.wauda.dto.comments.CommentsForm;
import com.thingk0.wauda.repository.CommentsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentsService {

    private final CommentsRepository commentsRepository;
    private final MemberService memberService;
    private final PartyService partyService;


    public List<CommentsDto> getCommentsList(Long partyId) {
        log.info("CommentsService.getCommentsList");
        return commentsRepository.commentsList(partyId);
    }


    @Transactional
    public Long addComment(CommentsForm commentsForm, String email) {
        Member member = memberService.findMemberByEmail(email);
        Party party = partyService.findPartyById(commentsForm.getPartyId());
        log.info("CommentsService.addComment");
        return commentsRepository.save(Comments.createComments(commentsForm, member, party)).getId();
    }

}
