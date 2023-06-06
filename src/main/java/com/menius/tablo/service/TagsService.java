package com.menius.tablo.service;

import com.menius.tablo.entities.requests.TagsRequestDto;
import com.menius.tablo.entities.response.TagsResponseDto;

import java.util.List;
import java.util.UUID;

public interface TagsService {
    void saveTag(TagsRequestDto tagsRequestDto);
    void deleteTagById(UUID tagId);
    TagsResponseDto getTagById(UUID tagId);
    List<TagsResponseDto> getTagsBySubsidiaryId(UUID subsidiaryId, int pages, int nrOfItems);
}
