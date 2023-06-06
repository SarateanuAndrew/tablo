package com.menius.tablo.service.impl;

import com.menius.tablo.entities.dbo.FoodDbo;
import com.menius.tablo.entities.dbo.RestaurantDbo;
import com.menius.tablo.entities.requests.FoodRequestDto;
import com.menius.tablo.entities.response.FoodResponseDto;
import com.menius.tablo.repository.FoodRepository;
import com.menius.tablo.repository.RestaurantRepository;
import com.menius.tablo.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.menius.tablo.entities.enms.Status.AVAILABLE;
import static com.menius.tablo.entities.enms.Status.DETACHED;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public void saveFood(FoodRequestDto foodRequestDto) {
        foodRepository.save(FoodDbo.builder()
                .foodId(foodRequestDto.getUuid())
                .status(foodRequestDto.getStatus())
                .foodIngredients(foodRequestDto.getFoodIngredients())
                .foodName(foodRequestDto.getFoodName())
                .foodPhoto(foodRequestDto.getFoodPhoto())
                .restaurantDbo(restaurantRepository.getByRestaurantId(foodRequestDto.getRestaurantId()).orElseThrow())
                .isSpicy(foodRequestDto.isSpicy())
                .isVegetarian(foodRequestDto.isVegetarian())
                .foodPrice(foodRequestDto.getFoodPrice())
                .isDeliverable(foodRequestDto.isDeliverable())
                .build());
    }

    @Override
    public List<FoodResponseDto> getAllFood(int pages, int nrOfItems) {
        return foodRepository.findAll(PageRequest.of(pages, nrOfItems)).stream()
                .filter(isAvailable())
                .map(DboToDto())
                .collect(toList());
    }

    @Override
    public FoodResponseDto getFoodById(UUID foodId) {
        FoodDbo foodDbo = foodRepository.findFoodDboByFoodId(foodId).orElseThrow();
        return FoodResponseDto.builder()
                .restaurantId(foodDbo.getRestaurantDbo().getRestaurantId())
                .foodId(foodDbo.getFoodId())
                .foodIngredients(foodDbo.getFoodIngredients())
                .foodName(foodDbo.getFoodName())
                .foodPhoto(foodDbo.getFoodPhoto())
                .status(foodDbo.getStatus())
                .isVegetarian(foodDbo.isVegetarian())
                .isSpicy(foodDbo.isSpicy())
                .foodPrice(foodDbo.getFoodPrice())
                .isDeliverable(foodDbo.isDeliverable())
                .build();
    }

    @Override
    public void deleteFood(UUID foodId) {
        foodRepository.deleteById(foodId);
    }

    @Override
    public List<FoodResponseDto> getSpicyFood(int pages, int nrOfItems) {
        return foodRepository.findAll(PageRequest.of(pages, nrOfItems))
                .stream()
                .filter(isAvailable())
                .filter(FoodDbo::isSpicy)
                .map(DboToDto())
                .collect(toList());
    }

    @Override
    public List<FoodResponseDto> getVegetarianFood(int pages, int nrOfItems) {
        return foodRepository.findAll(PageRequest.of(pages, nrOfItems))
                .stream()
                .filter(isAvailable())
                .filter(FoodDbo::isVegetarian)
                .map(DboToDto())
                .collect(toList());
    }

    @Override
    public List<FoodResponseDto> getFoodByRestaurant(UUID restaurantId, int pages, int nrOfItems) {
        RestaurantDbo restaurantDbo = restaurantRepository.findById(restaurantId).orElseThrow();
        return foodRepository.findFoodDboByRestaurantDbo(restaurantDbo, PageRequest.of(pages, nrOfItems))
                .stream()
                .filter(isAvailable())
                .map(DboToDto())
                .collect(toList());
    }

    @Override
    public void detach(UUID foodId) {
        foodRepository.findById(foodId).ifPresent(f -> f.setStatus(DETACHED));
    }

    private static Function<FoodDbo, FoodResponseDto> DboToDto() {
        return foodDbo -> FoodResponseDto.builder()
                .isSpicy(foodDbo.isSpicy())
                .status(foodDbo.getStatus())
                .foodPhoto(foodDbo.getFoodPhoto())
                .foodName(foodDbo.getFoodName())
                .foodIngredients(foodDbo.getFoodIngredients())
                .foodId(foodDbo.getFoodId())
                .isVegetarian(foodDbo.isVegetarian())
                .restaurantId(foodDbo.getRestaurantDbo().getRestaurantId())
                .foodPrice(foodDbo.getFoodPrice())
                .isDeliverable(foodDbo.isDeliverable())
                .build();
    }

    private static Predicate<FoodDbo> isAvailable() {
        return foodDbo -> foodDbo.getStatus().toString().equals(AVAILABLE.toString());
    }
}
