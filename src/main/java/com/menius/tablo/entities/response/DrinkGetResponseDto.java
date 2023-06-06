package com.menius.tablo.entities.response;

import com.menius.tablo.entities.dbo.RestaurantDbo;
import com.menius.tablo.entities.enms.Status;
import lombok.*;
import javax.persistence.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DrinkGetResponseDto {
    private UUID drinkId;
    private String drinkName;
    private String drinkPhoto;
    private String drinkIngredients;
    private boolean isAlcoholic;
    private double drinkPrice;
    private boolean isDeliverable;
    private Status status;
    private UUID restaurantId;
}

