package com.thingk0.wauda.repository;

import com.thingk0.wauda.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
