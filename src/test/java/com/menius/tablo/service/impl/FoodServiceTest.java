//package com.menius.tablo.service.impl;
//
//import com.menius.tablo.entities.dbo.FoodDbo;
//import com.menius.tablo.entities.dbo.RestaurantDbo;
//import com.menius.tablo.entities.requests.FoodRequestDto;
//import com.menius.tablo.entities.requests.GetNumberOfPage;
//import com.menius.tablo.repository.FoodRepository;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static com.menius.tablo.entities.enms.FoodStatus.AVAILABLE;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatCode;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(SpringExtension.class)
//public class FoodServiceTest {
//    @InjectMocks
//    private FoodServiceImpl foodService;
//
//    @Mock
//    private FoodRepository foodRepository;
//
//    @Test
//    void getAllFoods() {
//        when(foodRepository.findAll((Pageable) any())).thenReturn(Page.empty());
//        assertThat(foodService.getAllFood(GetNumberOfPage.builder()
//                .pages(5)
//                .nrOfItems(1)
//                .build()).size()).isEqualTo(0);
//    }
//
//    @Test
//    void getFoodById() {
//        FoodDbo foodDbo = FoodDbo.builder()
//                .restaurantDbo(RestaurantDbo.builder()
//                        .restaurantName("Andy")
//                        .restaurantPhoto("sd")
//                        .build())
//                .foodIngredients("ds")
//                .foodName("pizza")
//                .isDeliverable(true)
//                .foodPrice(23)
//                .isVegetarian(true)
//                .foodStatus(AVAILABLE)
//                .isSpicy(true)
//                .build();
//        when(foodRepository.findFoodDboByFoodId(any())).thenReturn(Optional.of(foodDbo));
//        assertThat(foodService.getFoodById(foodDbo.getFoodId()).getFoodName()).isEqualTo("pizza");
//    }
//
//    @Test
//    void saveFood() {
//        FoodRequestDto foodDbo = FoodRequestDto.builder()
//                .restaurantDbo(RestaurantDbo.builder()
//                        .restaurantName("Andy")
//                        .restaurantPhoto("sd")
//                        .build())
//                .foodIngredients("ds")
//                .foodName("pizza")
//                .isDeliverable(true)
//                .foodPrice(23)
//                .isVegetarian(true)
//                .foodStatus(AVAILABLE)
//                .isSpicy(true)
//                .build();
//        assertThatCode(() -> foodService.saveFood(foodDbo)).doesNotThrowAnyException();
//    }
//
//    @Test
//    void deleteFoodById() {
//        assertThatCode(() -> foodService.deleteFood(any())).doesNotThrowAnyException();
//    }
//
//    @Test
//    void detach() {
//        assertThatCode(() -> foodService.detach(any())).doesNotThrowAnyException();
//    }
//
//    @Test
//    @Disabled
//    void getFoodByRestaurants() {
//        RestaurantDbo build = RestaurantDbo.builder()
//                .restaurantName("Andy")
//                .restaurantPhoto("sd")
//                .build();
//        FoodDbo foodDbo = FoodDbo.builder()
//                .restaurantDbo(build)
//                .foodIngredients("ds")
//                .foodName("pizza")
//                .isDeliverable(true)
//                .foodPrice(23)
//                .isVegetarian(true)
//                .foodStatus(AVAILABLE)
//                .isSpicy(true)
//                .build();
//        when(foodRepository.findFoodDboByRestaurantDbo(any(), any())).thenReturn(List.of(foodDbo));
////        assertThatCode(() -> foodService.getFoodByRestaurants(build.getRestaurantId(), any())).doesNotThrowAnyException();
//        assertThat(foodService.getFoodByRestaurant(build.getRestaurantId(), any()).size()).isEqualTo(1);
//    }
//}
