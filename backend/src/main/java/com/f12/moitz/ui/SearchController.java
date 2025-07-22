package com.f12.moitz.ui;

import com.f12.moitz.common.MidPointCalculator;
import com.f12.moitz.infrastructure.service.MidPointService;
import com.f12.moitz.ui.dto.SearchResponse;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final MidPointService midPointService;

    @GetMapping("/search/{stations}")
    public ResponseEntity<SearchResponse> getSearchRecommendationMap(@RequestParam String request ){
        List<String> stations = Arrays.stream(request.split(",")).toList();
        midPointService.searchRecommendationMap(stations);
    }
}
