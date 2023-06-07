package com.thingk0.wauda.dto.party;

import com.thingk0.wauda.domain.constant.Category;
import com.thingk0.wauda.domain.constant.PartyStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartyListDto {

    private Long id;
    private String name;
    private String owner;
    private Category category;
    private PartyStatus partyStatus;
    private LocalDateTime createAt;
    private int count;

}
