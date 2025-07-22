package com.f12.moitz.infrastructure.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double longitude;

    private double latitude;

    private boolean isPopular;

    public static Station beforeSave(
            String name,
            double longitude,
            double latitude,
            boolean isPopular
    ) {
        return new Station(null,name,longitude,latitude,isPopular);
    }
}
