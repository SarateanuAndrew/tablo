package com.menius.tablo.service;

import com.menius.tablo.entities.requests.DrinkRequestDto;
import com.menius.tablo.entities.response.DrinkGetResponseDto;

import java.util.List;
import java.util.UUID;

public interface DrinksService {
    DrinkGetResponseDto getDrinkById(UUID uuid);
    void saveDrink(DrinkRequestDto requestDto);
    void detachDrinkFromMenu(UUID uuid);
    void deleteDrink(UUID uuid);
    List<DrinkGetResponseDto> getDrinkByRestaurant(UUID restaurantId, int pages, int nrOfItems);
}