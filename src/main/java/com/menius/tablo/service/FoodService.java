package com.menius.tablo.service;

import com.menius.tablo.entities.requests.FoodRequestDto;
import com.menius.tablo.entities.response.FoodResponseDto;

import java.util.List;
import java.util.UUID;

public interface FoodService {
    void saveFood(FoodRequestDto foodRequestDto);
    List<FoodResponseDto> getAllFood(int pages, int nrOfPages);
    FoodResponseDto getFoodById(UUID foodId);
    void deleteFood(UUID foodId);
    List<FoodResponseDto> getSpicyFood(int pages, int nrOfPages);
    List<FoodResponseDto> getVegetarianFood(int pages, int nrOfPages);
    List<FoodResponseDto> getFoodByRestaurant(UUID restaurantId, int pages, int nrOfPages);
    void detach(UUID foodId);
}