package com.f12.moitz.infrastructure.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class StationCategoryCount {

    @EmbeddedId
    private StationCategoryCountId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("stationId")  // maps to id.stationId
    @JoinColumn(name = "station_id")
    private Station station;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("categoryId") // maps to id.categoryId
    @JoinColumn(name = "category_id")
    private Category category;

    private int count = 0;
}
