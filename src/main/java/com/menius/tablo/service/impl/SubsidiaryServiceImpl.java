package com.menius.tablo.service.impl;

import com.menius.tablo.entities.dbo.RestaurantDbo;
import com.menius.tablo.entities.dbo.SubsidiariesDbo;
import com.menius.tablo.entities.requests.SubsidiaryAddRequestDto;
import com.menius.tablo.entities.response.SubsidiaryGetResponseDto;
import com.menius.tablo.repository.RestaurantRepository;
import com.menius.tablo.repository.SubsidiaryRepository;
import com.menius.tablo.service.SubsidiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.menius.tablo.entities.enms.Status.AVAILABLE;
import static com.menius.tablo.entities.enms.Status.DETACHED;

@Service
@RequiredArgsConstructor
public class SubsidiaryServiceImpl implements SubsidiaryService {
    private final SubsidiaryRepository subsidiaryRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public void addSubsidiary(SubsidiaryAddRequestDto subsidiaryAddRequestDto) {
        RestaurantDbo restaurantDbo = restaurantRepository.findById(subsidiaryAddRequestDto.getRestaurantId()).orElseThrow();
        subsidiaryRepository.save(SubsidiariesDbo.builder()
                .subsidiaryId(subsidiaryAddRequestDto.getUuid())
                .address(subsidiaryAddRequestDto.getAddress())
                .subsidiaryName(subsidiaryAddRequestDto.getSubsidiaryName())
                .schedule(subsidiaryAddRequestDto.getSchedule())
                .phoneNumber(subsidiaryAddRequestDto.getPhoneNumber())
                .restaurantDbo(restaurantDbo)
                .status(AVAILABLE)
                .build());
    }

    @Override
    public void detachSubsidiary(UUID uuid) {
        subsidiaryRepository.findById(uuid)
                .orElseThrow()
                .setStatus(DETACHED);
    }

    @Override
    public SubsidiaryGetResponseDto getSubsidiaryById(UUID id) {
        SubsidiariesDbo s = subsidiaryRepository.findById(id).orElseThrow();
        return SubsidiaryGetResponseDto.builder()
                .subsidiaryId(s.getSubsidiaryId())
                .subsidiaryName(s.getSubsidiaryName())
                .address(s.getAddress())
                .schedule(s.getSchedule())
                .phoneNumber(s.getPhoneNumber())
                .restaurantId(s.getRestaurantDbo().getRestaurantId())
                .status(s.getStatus())
                .build();
    }

    @Override
    public List<SubsidiaryGetResponseDto> getSubsidiaryByRestaurantId(UUID restaurantId, int pages, int nrOfItems) {
        RestaurantDbo restaurantDbo = restaurantRepository.getByRestaurantId(restaurantId).orElseThrow();
        return subsidiaryRepository.findByRestaurantDbo(restaurantDbo, PageRequest.of(pages, nrOfItems)).stream()
                .map(changeDboToDto())
                .collect(Collectors.toList());

    }

    @Override
    public void deleteSubsidiary(UUID subsidiaryId) {
        subsidiaryRepository.deleteById(subsidiaryId);
    }

    private static Function<SubsidiariesDbo, SubsidiaryGetResponseDto> changeDboToDto() {
        return subsidiariesDbo -> SubsidiaryGetResponseDto.builder()
                .subsidiaryId(subsidiariesDbo.getSubsidiaryId())
                .subsidiaryName(subsidiariesDbo.getSubsidiaryName())
                .address(subsidiariesDbo.getAddress())
                .schedule(subsidiariesDbo.getSchedule())
                .phoneNumber(subsidiariesDbo.getPhoneNumber())
                .restaurantId(subsidiariesDbo.getRestaurantDbo().getRestaurantId())
                .status(subsidiariesDbo.getStatus())
                .build();
    }

}