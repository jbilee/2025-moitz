package com.f12.moitz.infrastructure.dto;

public record LoadStationRequest(
        String name,
        double longitude,
        double latitude,
        boolean isPopular
) {
}
