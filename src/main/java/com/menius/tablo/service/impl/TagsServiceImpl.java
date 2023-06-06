package com.menius.tablo.service.impl;

import com.menius.tablo.entities.dbo.SubsidiariesDbo;
import com.menius.tablo.entities.dbo.TagsDbo;
import com.menius.tablo.entities.requests.TagsRequestDto;
import com.menius.tablo.entities.response.TagsResponseDto;
import com.menius.tablo.repository.SubsidiaryRepository;
import com.menius.tablo.repository.TagsRepository;
import com.menius.tablo.service.TagsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagsServiceImpl implements TagsService {
    private final TagsRepository tagsRepository;
    private final SubsidiaryRepository subsidiaryRepository;

    @Override
    public void saveTag(TagsRequestDto tagsRequestDto) {
        SubsidiariesDbo subsidiariesDbo = subsidiaryRepository.findById(tagsRequestDto.getSubsidiaryId()).orElseThrow();
        tagsRepository.save(TagsDbo.builder()
                .tagId(tagsRequestDto.getTagId())
                .tagName(tagsRequestDto.getTagName())
                .subsidiariesDbo(subsidiariesDbo)
                .build());
    }

    @Override
    public void deleteTagById(UUID tagId) {
        tagsRepository.deleteById(tagId);
    }

    @Override
    public TagsResponseDto getTagById(UUID tagId) {
        TagsDbo tagsDbo = tagsRepository.findById(tagId).orElseThrow();
        return TagsResponseDto.builder()
                .tagId(tagsDbo.getTagId())
                .tagName(tagsDbo.getTagName())
                .subsidiaryId(tagsDbo.getTagId())
                .build();
    }

    @Override
    public List<TagsResponseDto> getTagsBySubsidiaryId(UUID subsidiaryId, int pages, int nrOfItems) {
        return tagsRepository.findAllBySubsidiariesDbo(subsidiaryRepository.findById(subsidiaryId).orElseThrow(), PageRequest.of(pages, nrOfItems))
                .stream()
                .map(tagsDbo -> TagsResponseDto.builder()
                        .subsidiaryId(tagsDbo.getSubsidiariesDbo().getSubsidiaryId())
                        .tagId(tagsDbo.getTagId())
                        .tagName(tagsDbo.getTagName())
                        .build())
                .collect(Collectors.toList());
    }


}
