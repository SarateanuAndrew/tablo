package com.menius.tablo.entities.response;

import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TagsResponseDto {
    private UUID tagId;
    private String tagName;
    private UUID subsidiaryId;
}
