package com.menius.tablo.entities.requests;

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
public class FoodRequestDto {
    private UUID uuid;
    private String foodName;
    private String foodPhoto;
    private String foodIngredients;
    private UUID restaurantId;
    private Status status;
    private boolean isSpicy;
    private boolean isVegetarian;
    private double foodPrice;
    private boolean isDeliverable;
}