package com.menius.tablo.repository;

import com.menius.tablo.entities.dbo.DrinksDbo;
import com.menius.tablo.entities.dbo.RestaurantDbo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface DrinksRepository extends JpaRepository<DrinksDbo, UUID> {
    List<DrinksDbo> getDrinksDboByRestaurantDbo(RestaurantDbo restaurantDbo, Pageable pageable);
}
