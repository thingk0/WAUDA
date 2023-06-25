package com.thingk0.wauda.repository;

import com.thingk0.wauda.domain.Comments;
import com.thingk0.wauda.repository.comments.CustomCommentsRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long>, CustomCommentsRepository {
}
