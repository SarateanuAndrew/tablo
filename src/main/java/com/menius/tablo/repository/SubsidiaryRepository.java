package com.menius.tablo.repository;

import com.menius.tablo.entities.dbo.RestaurantDbo;
import com.menius.tablo.entities.dbo.SubsidiariesDbo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SubsidiaryRepository extends JpaRepository<SubsidiariesDbo, UUID> {
//    List<SubsidiariesDbo> findByRestaurantDboAndEntertainments(RestaurantDbo restaurantDbo, List<Entertainment> entertainments, Pageable pageable);
    List<SubsidiariesDbo> findByRestaurantDbo(RestaurantDbo restaurantDbo, Pageable pageable);
}