package com.menius.tablo.entities.response;

import com.menius.tablo.entities.enms.Status;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SubsidiaryGetResponseDto {
    private UUID subsidiaryId;
    private String subsidiaryName;
    private String address;
    private String schedule;
    private String phoneNumber;
    private UUID restaurantId;
    private Status status;
}
