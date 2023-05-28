package com.thingk0.wauda.repository;

import com.thingk0.wauda.domain.PartyMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyMemberRepository extends JpaRepository<PartyMember, Long> {
}
