package com.thingk0.wauda.repository;

import com.thingk0.wauda.domain.Party;
import com.thingk0.wauda.repository.party.CustomPartyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Long>, CustomPartyRepository {
}
