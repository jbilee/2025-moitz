package com.f12.moitz.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;

public record KakaoApiResponse(
        Meta meta
) {

    public int getTotalCount() {
        return meta.totalCount();
    }
}

record Meta(
        @JsonProperty("total_count") int totalCount
) {
}
