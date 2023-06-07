package com.thingk0.wauda.dto.party;

import com.thingk0.wauda.domain.constant.Category;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class PartyForm {

    @NotNull(message = "카테고리를 선택해주세요.")
    private Category category;

    @Size(min = 3, max = 20, message = "이름은 3-20자 사이로 입력해주세요.")
    @NotEmpty(message = "파티 이름을 입력해주세요.")
    private String name;

    @Size(max = 100, message = "상세 설명은 최대 100자까지 작성 가능합니다.")
    @NotEmpty(message = "파티 설명을 입력해주세요.")
    private String content;

    @Max(value = 8, message = "최대 8명까지 가능합니다.")
    private int memberCnt = 1;

}

