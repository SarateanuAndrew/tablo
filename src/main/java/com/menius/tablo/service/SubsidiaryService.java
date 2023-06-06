package com.menius.tablo.service;

import com.menius.tablo.entities.requests.SubsidiaryAddRequestDto;
import com.menius.tablo.entities.response.SubsidiaryGetResponseDto;

import java.util.List;
import java.util.UUID;

public interface SubsidiaryService {
    void addSubsidiary(SubsidiaryAddRequestDto subsidiaryAddRequestDto);

    void detachSubsidiary(UUID uuid);

    SubsidiaryGetResponseDto getSubsidiaryById(UUID id);

    List<SubsidiaryGetResponseDto> getSubsidiaryByRestaurantId(UUID restaurantId, int pages, int nrOfPages);

    void deleteSubsidiary(UUID subsidiaryId);
}