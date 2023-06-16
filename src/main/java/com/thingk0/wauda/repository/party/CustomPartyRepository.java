package com.thingk0.wauda.repository.party;

import com.thingk0.wauda.dto.party.PartyListDto;
import com.thingk0.wauda.dto.party.PartyResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomPartyRepository {
    Page<PartyListDto> partyList(String searchCond, Pageable pageable);
    PartyResponseDto partyDetail(Long party_id);
}
