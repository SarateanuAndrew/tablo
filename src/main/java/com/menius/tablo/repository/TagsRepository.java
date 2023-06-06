package com.menius.tablo.repository;

import com.menius.tablo.entities.dbo.SubsidiariesDbo;
import com.menius.tablo.entities.dbo.TagsDbo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface TagsRepository extends JpaRepository<TagsDbo, UUID> {
    List<TagsDbo> findAllBySubsidiariesDbo(SubsidiariesDbo subsidiariesDbo, Pageable pageable);
}
