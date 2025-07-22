package com.f12.moitz.infrastructure;

import com.f12.moitz.infrastructure.dto.NaverSearchResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class OdsayClient {

    private static final String ODSAY_SEARCH_API_URL = "https://api.odsay.com/v1/api/searchPubTransPathT";

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    @Value("${naver.api.key}")
    private String naverApiKey;

    public OdsayResponse calculateTravelTime(final String placeName, final String keyword, final int start) {
        final String url  = ODSAY_SEARCH_API_URL + "?SX=126.9027279&SY=37.5349277&EX=126.9145430&EY=37.5499421&apiKey=" + URLEncoder.encode(apiKey, "UTF-8");
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
