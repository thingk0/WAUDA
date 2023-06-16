package com.thingk0.wauda.dto.party;

import com.thingk0.wauda.domain.constant.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartyResponseDto {

    private Long id;
    private String name;
    private Category category;
    private String content;
    private String owner;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private int count;

}
