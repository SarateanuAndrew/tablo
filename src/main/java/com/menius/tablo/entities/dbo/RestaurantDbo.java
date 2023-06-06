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
@Table(name = "restaurant")
    public class RestaurantDbo {
    @Id
    @GeneratedValue
    private UUID restaurantId;
    @Column(nullable = false)
    private String restaurantName;
    @Column(nullable = false, unique = true)
    private String restaurantLogoUrl;
    @Column(nullable = false, unique = true)
    private String photoUrl;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private String phone_number;
    @Column(nullable = false)
    private int pricing;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String email;
}
