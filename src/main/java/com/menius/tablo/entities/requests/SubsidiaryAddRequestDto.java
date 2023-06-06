package com.menius.tablo.entities.requests;

import com.menius.tablo.entities.enms.Status;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SubsidiaryAddRequestDto {
    private UUID uuid;
    private UUID restaurantId;
    private String subsidiaryName;
    private String address;
    private String schedule;
    private String phoneNumber;
    private Status status;
}