package com.menius.tablo.entities.dbo;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tags")
public class TagsDbo {
    @Id
    @GeneratedValue
    private UUID tagId;
    @Column(nullable = false)
    private String tagName;
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE}
    )
    @JoinColumn(name = "subsidiary_id")
    private SubsidiariesDbo subsidiariesDbo;
}
