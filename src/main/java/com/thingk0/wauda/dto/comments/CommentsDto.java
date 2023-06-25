package com.thingk0.wauda.dto.comments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsDto {

    private Long commentsId;
    private String content;

    private Long memberId;
    private String nickname;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
