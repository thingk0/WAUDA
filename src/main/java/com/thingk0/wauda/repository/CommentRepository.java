package com.thingk0.wauda.repository;

import com.thingk0.wauda.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
