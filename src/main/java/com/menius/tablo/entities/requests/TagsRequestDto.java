package com.menius.tablo.entities.requests;

import com.menius.tablo.entities.dbo.SubsidiariesDbo;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TagsRequestDto {
    private UUID tagId;
    private String tagName;
    private UUID subsidiaryId;
}
