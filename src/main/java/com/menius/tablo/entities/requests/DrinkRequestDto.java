package com.menius.tablo.entities.requests;

import com.menius.tablo.entities.enms.Status;
import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DrinkRequestDto {
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