package com.thingk0.wauda.dto.party;

import com.thingk0.wauda.domain.constant.Category;
import com.thingk0.wauda.domain.constant.PartyStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartyListDto {

    private Long id;
    private String name;
    private Category category;
    private PartyStatus partyStatus;
    private int count;

}
