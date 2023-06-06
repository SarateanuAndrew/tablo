package com.menius.tablo.service.impl;

import com.menius.tablo.entities.dbo.RestaurantDbo;
import com.menius.tablo.entities.requests.RestaurantsGetRequestDto;
import com.menius.tablo.entities.response.RestaurantsGetResponseDto;
import com.menius.tablo.repository.RestaurantRepository;
import com.menius.tablo.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.menius.tablo.entities.enms.Status.AVAILABLE;
import static com.menius.tablo.entities.enms.Status.DETACHED;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantsGetResponseDto> getAllRestaurants(int pages, int nrOfItems) {
        return restaurantRepository.findAll(PageRequest.of(pages, nrOfItems)).stream()
                .filter(isAvailable())
                .map(r -> RestaurantsGetResponseDto.builder()
                        .restaurantId(r.getRestaurantId())
                        .restaurantName(r.getRestaurantName())
                        .restaurantLogoUrl(r.getRestaurantLogoUrl())
                        .description(r.getDescription())
                        .phone_number(r.getPhone_number())
                        .photoUrl(r.getPhotoUrl())
                        .pricing(r.getPricing())
                        .status(r.getStatus())
                        .email(r.getEmail())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantsGetResponseDto getRestaurantById(UUID restaurantId) {
        RestaurantDbo r = restaurantRepository.getByRestaurantId(restaurantId).orElseThrow();
        return RestaurantsGetResponseDto.builder()
                .restaurantId(r.getRestaurantId())
                .restaurantName(r.getRestaurantName())
                .restaurantLogoUrl(r.getRestaurantLogoUrl())
                .description(r.getDescription())
                .phone_number(r.getPhone_number())
                .photoUrl(r.getPhotoUrl())
                .pricing(r.getPricing())
                .email(r.getEmail())
                .status(r.getStatus())
                .build();
    }

    @Override
    public void saveRestaurant(RestaurantsGetRequestDto r) {
        restaurantRepository.save(RestaurantDbo.builder()
                .restaurantId(r.getRestaurantId())
                .restaurantName(r.getRestaurantName())
                .restaurantLogoUrl(r.getRestaurantLogoUrl())
                .description(r.getDescription())
                .phone_number(r.getPhone_number())
                .photoUrl(r.getPhotoUrl())
                .pricing(r.getPricing())
                .email(r.getEmail())
                .status(r.getStatus())
                .build());
    }

    @Override
    public void deleteRestaurantById(UUID restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }

    @Override
    public void detach(UUID restaurantId) {
        restaurantRepository.getByRestaurantId(restaurantId).ifPresent(r -> r.setStatus(DETACHED));
    }

    private static Predicate<RestaurantDbo> isAvailable() {
        return restaurantDbo -> restaurantDbo.getStatus().toString().equals(AVAILABLE.toString());
    }

}
