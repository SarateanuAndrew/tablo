//package com.menius.tablo;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.menius.tablo.dto.request.SubsidiaryAddRequestDto;
//import com.menius.tablo.dto.request.SubsidiaryByEntertainment;
//import com.menius.tablo.dto.request.SubsidiaryByRestaurant;
//import com.menius.tablo.dto.response.SubsidiaryGetResponseDto;
//import com.menius.tablo.entities.dbo.RestaurantDbo;
//import com.menius.tablo.entities.SubsidiaryDbo;
//import com.menius.tablo.repository.RestaurantRepository;
//import com.menius.tablo.repository.SubsidiaryRepository;
//import lombok.SneakyThrows;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//
//import java.util.List;
//import java.util.UUID;
//
//import static com.menius.tablo.enums.Entertainment.HOOKAH;
//import static com.menius.tablo.enums.SubsidiaryStatus.ACTIVE;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class TabloApplicationTests {
//    @Autowired
//    private SubsidiaryRepository subsidiaryRepository;
//    @Autowired
//    private RestaurantRepository restaurantRepository;
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    @Disabled
//    public void addSubsidiarySuccess() throws Exception {
//        RestaurantDbo restaurantDbo = RestaurantDbo.builder()
//                .restaurantName("name")
//                .restaurantPhoto("photo")
//                .build();
//        restaurantRepository.save(restaurantDbo);
//
//        SubsidiaryAddRequestDto subsidiaryAddRequestDto = SubsidiaryAddRequestDto.builder()
//                .subsidiaryName("sub")
//                .subsidiaryPhoto("photo")
//                .address("here")
//                .schedule("test")
//                .entertainments(List.of(HOOKAH))
//                .restaurant(restaurantDbo.getRestaurantId())
//                .build();
//
//        mockMvc.perform(post("/api/subsidiary/add-subsidiary")
//                        .contentType("application/json")
//                        .content(objectMapper.writeValueAsString(subsidiaryAddRequestDto)))
//                .andExpect(status().isCreated());
//
//        assertThat(subsidiaryRepository.findAll().size()).isEqualTo(1);
//    }
//
//    @Test
//    @SneakyThrows
//    public void addSubsidiaryEmpty() {
//        assertThat(subsidiaryRepository.findAll()).isEmpty();
//    }
//
////    @Test
////    @SneakyThrows
////    @Disabled
////    public void detachSubsidiarySuccess() {
////        RestaurantDbo restaurantDbo = RestaurantDbo.builder()
////                .restaurantName("name")
////                .restaurantPhoto("photo")
////                .build();
////        restaurantRepository.save(restaurantDbo);
////
////        SubsidiaryDbo subsidiaryDbo = SubsidiaryDbo.builder()
////                .subsidiaryName("sub")
////                .subsidiaryPhoto("photo")
////                .address("here")
////                .schedule("test")
////                .subsidiaryStatus(ACTIVE)
////                .restaurant(restaurantDbo)
////                .build();
////        subsidiaryRepository.save(subsidiaryDbo);
////
////        mockMvc.perform(put("/api/subsidiary/detach-subsidiary")
////                .contentType("application/json")
////                .content(objectMapper.writeValueAsString(subsidiaryDbo.getSubsidiaryId()))
////                .param("subsidiaryId", subsidiaryDbo.getSubsidiaryId().toString()))
////                .andExpect(status().isAccepted());
////        boolean equals = subsidiaryRepository.findAll().get(0).getSubsidiaryStatus().equals(DETACHED);
////        assertThat(equals).isTrue();
////    }
//
//
//    @Test
//    public void detachSubsidiaryActive() {
//        RestaurantDbo restaurantDbo = RestaurantDbo.builder()
//                .restaurantName("name")
//                .restaurantPhoto("photo")
//                .build();
//        restaurantRepository.save(restaurantDbo);
//
//        SubsidiaryDbo subsidiaryDbo = SubsidiaryDbo.builder()
//                .subsidiaryName("sub")
//                .subsidiaryPhoto("photo")
//                .address("here")
//                .schedule("test")
//                .subsidiaryStatus(ACTIVE)
//                .restaurant(restaurantDbo)
//                .build();
//
//        subsidiaryRepository.save(subsidiaryDbo);
//        assertThat(subsidiaryRepository.findAll().get(0).getSubsidiaryStatus()).isEqualTo(ACTIVE);
//    }
//
//    //
//    @Test
//    @SneakyThrows
//    public void getSubsidiaryByIdSuccess() {
//        RestaurantDbo restaurantDbo = RestaurantDbo.builder()
//                .restaurantName("name")
//                .restaurantPhoto("photo")
//                .build();
//        restaurantRepository.save(restaurantDbo);
//
//        SubsidiaryDbo subsidiaryDbo = SubsidiaryDbo.builder()
//                .subsidiaryName("sub")
//                .subsidiaryPhoto("photo")
//                .address("here")
//                .schedule("test")
//                .subsidiaryStatus(ACTIVE)
//                .restaurant(restaurantDbo)
//                .build();
//
//        subsidiaryRepository.save(subsidiaryDbo);
//        MvcResult subsidiaryId = mockMvc.perform(get("/api/subsidiary/get-subsidiary-by-id")
//                        .contentType("application/json")
//                        .content(objectMapper.writeValueAsString(subsidiaryDbo.getSubsidiaryId()))
//                        .param("subsidiaryId", subsidiaryDbo.getSubsidiaryId().toString()))
//                .andExpect(status().isAccepted()).andReturn();
//        String contentAsString = subsidiaryId.getResponse().getContentAsString();
//        SubsidiaryGetResponseDto subsidiaryGetResponseDto =
//                objectMapper.readValue(contentAsString, SubsidiaryGetResponseDto.class);
//        assertThat(subsidiaryGetResponseDto.getSubsidiaryName()).isEqualTo("sub");
//    }
//
//    @Test
//    @SneakyThrows
//    @Disabled
//    public void getSubsidiaryByIdNotFound() {
//        UUID uuid = UUID.randomUUID();
//        MvcResult subsidiaryId = mockMvc.perform(get("/api/subsidiary/get-subsidiary-by-id")
//                        .contentType("application/json")
//                        .content(objectMapper.writeValueAsString(uuid))
//                        .param("subsidiaryId", uuid.toString()))
//                .andExpect(status().isAccepted()).andReturn();
//        String contentAsString = subsidiaryId.getResponse().getContentAsString();
//        assertThat(contentAsString).isEmpty();
//
//    }
//
//
//    @Test
//    @SneakyThrows
//    public void findSubsidiaryByRestaurant() {
//        RestaurantDbo restaurantDbo = RestaurantDbo.builder()
//                .restaurantName("name")
//                .restaurantPhoto("photo")
//                .build();
//        restaurantRepository.save(restaurantDbo);
//        SubsidiaryDbo subsidiaryDbo = SubsidiaryDbo.builder()
//                .subsidiaryName("sub")
//                .subsidiaryPhoto("photo")
//                .address("here")
//                .schedule("test")
//                .entertainments(List.of(HOOKAH))
//                .subsidiaryStatus(ACTIVE)
//                .restaurant(restaurantDbo)
//                .build();
//
//        subsidiaryRepository.save(subsidiaryDbo);
//
//        SubsidiaryByRestaurant subsidiary = SubsidiaryByRestaurant.builder()
//                .restaurantId(List.of(restaurantDbo.getRestaurantId()))
//                .page(1)
//                .size(1)
//                .build();
//        MvcResult mvcResult = mockMvc
//                .perform(get("/api/subsidiary/get-subsidiary-by-restaurant")
//                        .contentType("application/json")
//                        .content(objectMapper.writeValueAsString(subsidiary)))
//                .andExpect(status().isAccepted())
//                .andReturn();
//        String contentAsString = mvcResult.getResponse().getContentAsString();
//        SubsidiaryGetResponseDto subsidiaryGetResponseDto =
//                objectMapper.readValue(contentAsString, SubsidiaryGetResponseDto.class);
//        assertThat(subsidiaryGetResponseDto.getSubsidiaryName()).isEqualTo("name");
//    }
//}
////
////    @Test
////    public void findSubsidiaryByRestaurantNotFound() {
//////        List<SubsidiaryGetResponseDto> subsidiaryByRestaurant = subsidiaryService.getSubsidiaryByRestaurant(
//////                RestaurantGetRequestDto.builder()
//////                        .restaurantId(UUID.randomUUID())
//////                        .page(0)
//////                        .size(1)
//////                        .restaurantName("name")
//////                        .build());
//////        Assertions.assertThat(subsidiaryByRestaurant).isEmpty();
////    }
////
////    @Test
////    @SqlGroup({
////            @Sql(value = "classpath:sql/insert-restaurant.sql", executionPhase = BEFORE_TEST_METHOD)
////    }
////    )
////    public void findSubsidiaryByRestaurantAndEntertainmentSuccess() {
////        RestaurantDbo restaurantDbo = RestaurantDbo.builder()
////                .restaurantName("name")
////                .restaurantPhoto("photo")
////                .build();
////        restaurantRepository.save(restaurantDbo);
////        SubsidiaryDbo subsidiaryDbo = SubsidiaryDbo.builder()
////                .subsidiaryName("sub")
////                .subsidiaryPhoto("photo")
////                .address("here")
////                .schedule("test")
////                .subsidiaryStatus(ACTIVE)
////                .restaurant(restaurantDbo)
////                .entertainments(List.of(HOOKAH))
////                .build();
////
////        subsidiaryRepository.save(subsidiaryDbo);
////        SubsidiaryByEntertainment subsidiary = SubsidiaryByEntertainment.builder()
////                .entertainment(List.of(HOOKAH))
////                .page(0)
////                .size(1)
////                .restaurants(List.of(restaurantDbo.getRestaurantId()))
////                .build();
//////        List<SubsidiaryGetResponseDto> subsidiaryByRestaurantAndEntertainment =
//////                subsidiaryService.getSubsidiaryByRestaurantAndEntertainment(subsidiary);
//////        Assertions.assertThat((int) subsidiaryByRestaurantAndEntertainment.size()).isEqualTo(1);
////    }
////
////    @Test
////    @SqlGroup({
////            @Sql(value = "classpath:sql/insert-restaurant.sql", executionPhase = BEFORE_TEST_METHOD)
////    }
////    )
////    public void findSubsidiaryByRestaurantAndEntertainmentNotFound() {
////        RestaurantDbo restaurant = RestaurantDbo.builder()
////                .restaurantId(UUID.randomUUID())
////                .restaurantName("name")
////                .restaurantPhoto("photo")
////                .build();
////        restaurantRepository.save(restaurant);
////
////        SubsidiaryByEntertainment subsidiary = SubsidiaryByEntertainment.builder()
////                .entertainment(List.of(HOOKAH))
////                .page(0)
////                .size(1)
////                .restaurants(List.of(restaurant.getRestaurantId()))
////                .build();
////
//////        List<SubsidiaryGetResponseDto> subsidiaryByRestaurantAndEntertainment =
//////                subsidiaryService.getSubsidiaryByRestaurantAndEntertainment(subsidiary);
//////
//////        Assertions.assertThat(subsidiaryByRestaurantAndEntertainment).isEmpty();
////    }
////}
