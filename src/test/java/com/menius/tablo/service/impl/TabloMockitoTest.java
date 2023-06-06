//package com.menius.tablo;
//
//import com.menius.tablo.dto.request.SubsidiaryByRestaurant;
//import com.menius.tablo.dto.request.SubsidiaryAddRequestDto;
//import com.menius.tablo.dto.request.SubsidiaryByEntertainment;
//import com.menius.tablo.dto.response.SubsidiaryGetResponseDto;
//import com.menius.tablo.entities.dbo.RestaurantDbo;
//import com.menius.tablo.entities.SubsidiaryDbo;
//import com.menius.tablo.entities.dbo.SubsidiariesDbo;
//import com.menius.tablo.entities.enms.Status;
//import com.menius.tablo.entities.requests.SubsidiaryAddRequestDto;
//import com.menius.tablo.entities.response.SubsidiaryGetResponseDto;
//import com.menius.tablo.repository.RestaurantRepository;
//import com.menius.tablo.repository.SubsidiaryRepository;
//import com.menius.tablo.service.impl.SubsidiaryServiceImpl;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//
//import static com.menius.tablo.entities.enms.Status.AVAILABLE;
//import static com.menius.tablo.enums.Entertainment.HOOKAH;
//import static com.menius.tablo.enums.Entertainment.PLAY_GROUND;
//import static com.menius.tablo.enums.SubsidiaryStatus.ACTIVE;
//import static com.menius.tablo.enums.SubsidiaryStatus.DETACHED;
//import static java.util.Collections.*;
//import static java.util.Objects.requireNonNull;
//import static java.util.Optional.empty;
//import static java.util.Optional.ofNullable;
//import static java.util.UUID.randomUUID;
//import static org.assertj.core.api.Assertions.*;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(SpringExtension.class)
//public class TabloMockitoTest {
//    @InjectMocks
//    private SubsidiaryServiceImpl service;
//    @Mock
//    private SubsidiaryRepository subsidiaryRepository;
//    @Mock
//    private RestaurantRepository restaurantRepository;
//
//    @Test
//    public void addSubsidiary() {
//        RestaurantDbo restaurantDbo = RestaurantDbo.builder()
//                .restaurantName("name")
//                .build();
//        when(restaurantRepository.findById(any())).thenReturn(ofNullable(restaurantDbo));
//        SubsidiaryAddRequestDto subsidiary = SubsidiaryAddRequestDto.builder()
//                .restaurant(randomUUID())
//                .subsidiaryName("name")
//                .build();
//        assertThatCode(() -> service.addSubsidiary(subsidiary)).doesNotThrowAnyException();
//    }
//
//    @Test
//    public void getSubsidiaryByRestaurant() {
//        RestaurantDbo restaurantDbo = RestaurantDbo.builder()
//                .restaurantName("name")
//                .build();
//        SubsidiariesDbo subsidiaryDbo = SubsidiariesDbo.builder()
//                .subsidiaryName("sub")
//                .address("here")
//                .schedule("test")
//                .status(AVAILABLE)
//                .restaurantDbo(restaurantDbo)
//                .build();
//
//        when(restaurantRepository.findById(any())).thenReturn(ofNullable(restaurantDbo));
//        when(subsidiaryRepository.findByRestaurant(any(), any())).thenReturn(List.of(subsidiaryDbo));
//        assertThat(service.getSubsidiaryByRestaurant(
//                SubsidiaryByRestaurant.builder()
//                        .restaurantId(List.of(randomUUID()))
//                        .size(1)
//                        .page(0)
//                        .build())
//                .size()).isEqualTo(1);
//    }
//
//    @Test
//    public void getSubsidiaryByRestaurantEmptyList() {
//        when(restaurantRepository.findById(any())).thenReturn(ofNullable(
//                RestaurantDbo.builder()
//                .restaurantId(randomUUID())
//                .build()));
//        when(subsidiaryRepository.findByRestaurant(any(), any())).thenReturn(emptyList());
//        assertThat(service.getSubsidiaryByRestaurant(SubsidiaryByRestaurant.builder()
//                        .restaurantId(List.of(randomUUID()))
//                        .size(1)
//                        .page(0)
//                        .build())
//                .isEmpty());
//    }
//
//    @Test
//    public void getSubsidiaryByRestaurantAndEntertainment() {
//        RestaurantDbo restaurantDbo = RestaurantDbo.builder()
//                .restaurantId(randomUUID())
//                .restaurantName("name")
//                .restaurantPhoto("photo")
//                .build();
//
//        SubsidiaryDbo subsidiaryDbo = SubsidiaryDbo.builder()
//                .subsidiaryName("sub")
//                .subsidiaryPhoto("photo")
//                .address("here")
//                .entertainments(List.of(HOOKAH))
//                .schedule("test")
//                .subsidiaryStatus(ACTIVE)
//                .restaurant(restaurantDbo)
//                .build();
//        when(restaurantRepository.findById(any())).thenReturn(ofNullable(restaurantDbo));
//        when(subsidiaryRepository.findByRestaurantAndEntertainments(any(), any(), any())).thenReturn(List.of(subsidiaryDbo));
//        assertThat(service.getSubsidiaryByRestaurantAndEntertainment(
//                SubsidiaryByEntertainment.builder()
//                        .entertainment(List.of(HOOKAH))
//                        .size(1)
//                        .page(0)
//                        .restaurants(List.of(restaurantDbo.getRestaurantId()))
//                        .build()).size()).isOne();
//    }
//
//    @Test
//    public void getSubsidiaryByRestaurantAndEntertainmentEmptyList() {
//        when(restaurantRepository.findById(any())).thenReturn(ofNullable(
//                RestaurantDbo.builder()
//                        .restaurantId(randomUUID())
//                        .build()));
//        when(subsidiaryRepository.findByRestaurantAndEntertainments(any(), any(), any())).thenReturn(emptyList());
//        assertThat(service.getSubsidiaryByRestaurantAndEntertainment(
//                SubsidiaryByEntertainment.builder()
//                        .entertainment(List.of(PLAY_GROUND))
//                        .size(1)
//                        .page(0)
//                        .restaurants(List.of(randomUUID()))
//                        .build()).isEmpty());
//    }
//
//    @Test
//    public void getById() {
//        RestaurantDbo restaurantDbo = RestaurantDbo.builder()
//                .restaurantName("name")
//                .build();
//        SubsidiariesDbo subsidiaryDbo = SubsidiariesDbo.builder()
//                .subsidiaryName("sub")
//                .subsidiaryPhoto("photo")
//                .address("here")
//                .entertainments(List.of(HOOKAH))
//                .schedule("test")
//                .status(ACTIVE)
//                .restaurant(restaurantDbo)
//                .build();
//        when(subsidiaryRepository.findById(any())).thenReturn(ofNullable(subsidiaryDbo));
//        SubsidiaryGetResponseDto subsidiaryById = service.getSubsidiaryById(randomUUID());
//        assertThat(subsidiaryById.getSubsidiaryName()).isEqualTo("sub");
//    }
//
//    @Test
//    public void getByIdEmptyList() {
//        when(subsidiaryRepository.findById(any())).thenReturn(empty());
//        assertThatThrownBy(() -> service.getSubsidiaryById(randomUUID()));
//    }
//
//    @Test
//    public void detachSubsidiary() {
//        SubsidiaryDbo subsidiaryDbo = SubsidiaryDbo.builder()
//                .subsidiaryId(randomUUID())
//                .subsidiaryStatus(ACTIVE)
//                .build();
//        when(subsidiaryRepository.findById(any())).thenReturn(ofNullable(subsidiaryDbo));
//        assertThatCode(() -> service.detachSubsidiary(requireNonNull(subsidiaryDbo).getSubsidiaryId()))
//                .doesNotThrowAnyException();
//        assertThat(requireNonNull(subsidiaryDbo).getSubsidiaryStatus()).isEqualTo(DETACHED);
//    }
//}
