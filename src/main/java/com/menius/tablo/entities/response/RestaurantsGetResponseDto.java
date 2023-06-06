package com.menius.tablo.entities.response;

import com.menius.tablo.entities.enms.Status;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RestaurantsGetResponseDto {
    private UUID restaurantId;
    private String restaurantName;
    private String restaurantLogoUrl;
    private String photoUrl;
    private Status status;
    private String phone_number;
    private int pricing;
    private String description;
    private String email;
}
