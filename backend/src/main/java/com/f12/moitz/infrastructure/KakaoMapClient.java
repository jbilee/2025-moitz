package com.f12.moitz.infrastructure;

import com.f12.moitz.infrastructure.dto.KakaoApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
@Component
public class KakaoMapClient {

    private static final String KAKAO_MAP_API_URL = "https://dapi.kakao.com/v2/local/search";

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    @Value("${kakao.api.key}")
    private String kakaoApiKey;

    public KakaoApiResponse searchPlaceBy(final double x, final double y, final String keyword, final String code) {
        final String url = KAKAO_MAP_API_URL + "/keyword.json" + "?query=" + keyword + "&x=" + x + "&y=" + y + "&category_group_code=" + code + "&radius=700";
        return getData(url);
    }

    private KakaoApiResponse getData(final String url) {
        // TODO: 예외 처리, 응답에 따른 핸들링
        return restClient.get()
                .uri(url)
                .header("Authorization", "KakaoAK " + kakaoApiKey)
                .retrieve()
                .body(KakaoApiResponse.class);
    }

}
