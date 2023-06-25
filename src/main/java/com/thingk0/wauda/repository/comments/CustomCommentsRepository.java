package com.thingk0.wauda.repository.comments;

import com.thingk0.wauda.dto.comments.CommentsDto;

import java.util.List;

public interface CustomCommentsRepository {
    List<CommentsDto> commentsList(Long partyId);
}
