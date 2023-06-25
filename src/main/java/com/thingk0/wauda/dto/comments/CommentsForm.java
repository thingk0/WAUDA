package com.thingk0.wauda.dto.comments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsForm {

    private Long partyId;

    @NotEmpty(message = "댓글을 작성해 주세요.")
    @Size(min = 1, max = 100, message = "댓글은 최소 1글자 이상 100글자 이하로 작성해주세요.")
    private String comment;
}
