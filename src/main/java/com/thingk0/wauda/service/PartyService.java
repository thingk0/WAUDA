package com.thingk0.wauda.service;

import com.thingk0.wauda.domain.Party;
import com.thingk0.wauda.dto.party.PartyForm;
import com.thingk0.wauda.dto.party.PartyListDto;
import com.thingk0.wauda.dto.party.PartyResponseDto;
import com.thingk0.wauda.repository.PartyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PartyService {

    private final PartyRepository partyRepository;
    private final MemberService memberService;

    public Long create(PartyForm partyForm, String email) {
        return partyRepository.save(Party.create(partyForm, memberService.findMemberByEmail(email))).getId();
    }

    @Transactional(readOnly = true)
    public Page<PartyListDto> getPartyList(String search, Pageable pageable) {
        return partyRepository.partyList(search, pageable);
    }

    @Transactional(readOnly = true)
    public PartyResponseDto getPartyDetail(Long id) {
        return partyRepository.partyDetail(id);
    }

}
