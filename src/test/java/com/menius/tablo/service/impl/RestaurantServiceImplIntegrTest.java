//package com.menius.tablo.service.impl;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.menius.tablo.entities.dbo.RestaurantDbo;
//import com.menius.tablo.entities.requests.GetNumberOfPage;
//import com.menius.tablo.entities.requests.RestaurantsGetRequestDto;
//import com.menius.tablo.entities.response.RestaurantsGetResponseDto;
//import com.menius.tablo.repository.RestaurantRepository;
//import com.menius.tablo.service.RestaurantService;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static com.menius.tablo.entities.enms.Status.AVAILABLE;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class RestaurantServiceImplIntegrTest {
//    @Autowired
//    private RestaurantService restaurantService;
//    @Autowired
//    private RestaurantRepository restaurantRepository;
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//    @Test
//    @Disabled
//    void getAllRestaurants() throws Exception {
////        RestaurantDbo restaurantDbo = RestaurantDbo.builder()
////                .restaurantName("Andy")
////                .restaurantPhoto("sd")
////                .restaurantStatus(AVAILABLE)
////                .build();
//
//        restaurantRepository.save(RestaurantDbo.builder()
//                .restaurantName("Andy")
//                .restaurantPhoto("sd")
//                .status(AVAILABLE)
//                .build());
//
//        MvcResult mvcResult = mockMvc.perform(get("/api/tablo/restaurant/get-all-restaurants")
//                        .content(objectMapper.writeValueAsString(GetNumberOfPage.builder()
//                                .pages(3)
//                                .nrOfItems(2)
//                                .build()))
//                        .contentType("application/json"))
//                .andExpect(status().isAccepted()).andReturn();
//
//        String contentAsString = mvcResult.getResponse().getContentAsString();
//        List<RestaurantsGetResponseDto> restaurantsGetResponseDtoList = Arrays.asList(objectMapper.readValue(contentAsString, RestaurantsGetResponseDto[].class));
//        assertThat(restaurantsGetResponseDtoList.size()).isEqualTo(1);
//    }
//
//    @Test
//    void getRestaurantById() throws Exception {
//        RestaurantDbo restaurantDbo = RestaurantDbo.builder()
//                .restaurantName("Andy")
//                .restaurantPhoto("sd")
//                .status(AVAILABLE)
//                .build();
//        restaurantRepository.save(restaurantDbo);
//        MvcResult mvcResult = mockMvc.perform(get("/api/tablo/restaurant/get-restaurant-by-id")
//                        .contentType("application/json")
//                        .param("restaurantId", restaurantDbo.getRestaurantId().toString()))
//                .andExpect(status().isFound()).andReturn();
//
//    }
//
//    @Test
//    @Disabled
//    void saveRestaurant() throws Exception {
//        RestaurantsGetRequestDto restaurantsGetRequestDto = RestaurantsGetRequestDto.builder()
//                .restaurantName("Andy")
//                .restaurantPhoto("sd")
//                .status(AVAILABLE)
//                .build();
//        mockMvc.perform(put("/api/tablo/restaurant/save-restaurant")
//                        .contentType("application/json")
//                        .param("id", restaurantsGetRequestDto.toString()))
//                .andExpect(status().isCreated());
//    }
//
//    @Test
//    @Disabled
//    void deleteRestaurantById() throws Exception {
//        RestaurantDbo restaurantDbo = RestaurantDbo.builder()
//                .restaurantName("Andy")
//                .restaurantPhoto("sd")
//                .status(AVAILABLE)
//                .build();
//        restaurantRepository.save(restaurantDbo);
//        mockMvc.perform(delete("/api/tablo/restaurant/delete-restaurant")
//                        .contentType("application/json")
//                        .param("id", restaurantDbo.getRestaurantId().toString()))
//                .andExpect(status().isOk());
//
//    }
//
//    @Test
//    @Disabled
//    void detach() {
//
//    }
//
//}
