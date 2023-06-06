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
@Table(name = "subsidiary")
public class SubsidiariesDbo {
    @Id
    @GeneratedValue
    private UUID subsidiaryId;
    @Column(nullable = false)
    private String subsidiaryName;
    @Column(unique = true, nullable = false)
    private String address;
    @Column(nullable = false)
    private String schedule;
    @Column(nullable = false)
    private String phoneNumber;
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE}
    )
    @JoinColumn(name = "restaurant_id")
    private RestaurantDbo restaurantDbo;
    @Enumerated(EnumType.STRING)
    private Status status;
}
