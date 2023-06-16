package com.thingk0.wauda.repository;

import com.thingk0.wauda.domain.Member;
import com.thingk0.wauda.dto.member.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m WHERE m.email = :email")
    Optional<Member> findByEmail(@Param("email") String email);

    boolean existsByEmail(String email);

    @Query("select new com.thingk0.wauda.dto.member.Profile(m.id, m.email, m.nickname, m.role) from Member m where m.email = :email")
    Optional<Profile> getProfileByEmail(@Param("email") String email);

}
