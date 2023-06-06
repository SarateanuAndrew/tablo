package com.menius.tablo.entities.dbo;

import com.menius.tablo.entities.enms.Status;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "food_menu")
public class FoodDbo {
    @Id
    @GeneratedValue
    private UUID foodId;
    @Column(nullable = false, unique = true)
    private String foodName;
    private String foodPhoto;
    private String foodIngredients;
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE}
    )
    @JoinColumn(name = "restaurant_id")
    private RestaurantDbo restaurantDbo;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private boolean isSpicy;
    @Column(nullable = false)
    private boolean isVegetarian;
    @Column(nullable = false)
    private double foodPrice;
    @Column(nullable = false)
    private boolean isDeliverable;
}
