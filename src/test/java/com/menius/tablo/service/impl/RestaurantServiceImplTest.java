//package com.menius.tablo.service.impl;
//
//import com.menius.tablo.entities.dbo.RestaurantDbo;
//import com.menius.tablo.entities.requests.GetNumberOfPage;
//import com.menius.tablo.entities.requests.RestaurantsGetRequestDto;
//import com.menius.tablo.repository.RestaurantRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatCode;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(SpringExtension.class)
//class RestaurantServiceImplTest {
//    @InjectMocks
//    private RestaurantServiceImpl restaurantService;
//
//    @Mock
//    private RestaurantRepository restaurantRepository;
//
//    @Test
//    void getAllRestaurants() {
//        RestaurantDbo restaurantDbo = RestaurantDbo.builder()
//                .restaurantName("Andy")
//                .restaurantPhoto("sd")
//                .build();
//        when(restaurantRepository.findAll((Pageable) any())).thenReturn(Page.empty());
//        assertThat(restaurantService.getAllRestaurants(GetNumberOfPage.builder()
//                .pages(5)
//                .nrOfItems(1)
//                .build()).size()).isEqualTo(0);
//    }
//
//    @Test
//    void getRestaurantById() {
//        RestaurantDbo restaurantDbo = RestaurantDbo.builder()
//                .restaurantName("Andy")
//                .restaurantPhoto("sd")
//                .build();
//        when(restaurantRepository.getByRestaurantId(any())).thenReturn(Optional.of(restaurantDbo));
//        assertThat(restaurantService.getRestaurantById(restaurantDbo.getRestaurantId()).getRestaurantName()).isEqualTo("Andy");
//    }
//
//    @Test
//    void saveRestaurant() {
//        RestaurantsGetRequestDto restaurantDbo = RestaurantsGetRequestDto.builder()
//                .restaurantName("Andy")
//                .restaurantPhoto("sd")
//                .build();
//        assertThatCode(() -> restaurantService.saveRestaurant(restaurantDbo)).doesNotThrowAnyException();
//    }
//
//    @Test
//    void deleteRestaurantById() {
//        assertThatCode(() -> restaurantService.deleteRestaurantById(any())).doesNotThrowAnyException();
//    }
//
//    @Test
//    void detach() {
//        assertThatCode(() -> restaurantService.detach(any())).doesNotThrowAnyException();
//    }
//}