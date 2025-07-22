package com.f12.moitz.infrastructure;

import com.f12.moitz.infrastructure.dto.KakaoApiResponse;
import com.f12.moitz.infrastructure.dto.NaverSearchResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
@Component
public class NaverSearchClient {

    private static final String NAVER_SEARCH_API_URL = "https://openapi.naver.com/v1/search/local.json";

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    @Value("${naver.api.key}")
    private String naverApiKey;

    public NaverSearchResponse searchPlaceBy(final String placeName, final String keyword, final int start) {
        final String url = NAVER_SEARCH_API_URL + "?query=" + placeName + " " + keyword + "&display=30&start=" + start;
        return getData(url);
    }

    private NaverSearchResponse getData(final String url) {
        // TODO: 예외 처리, 응답에 따른 핸들링
        return restClient.get()
                .uri(url)
                .header("X-Naver-Client-Id", "xgTupFy1Herb0GFXLsSx")
                .header("X-Naver-Client-Secret", naverApiKey)
                .retrieve()
                .body(NaverSearchResponse.class);
    }

}
