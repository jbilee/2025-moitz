package com.f12.moitz.infrastructure.service;

import com.f12.moitz.infrastructure.KakaoMapClient;
import com.f12.moitz.infrastructure.domain.Category;
import com.f12.moitz.infrastructure.domain.Station;
import com.f12.moitz.infrastructure.domain.StationCategoryCount;
import com.f12.moitz.infrastructure.domain.StationCategoryCountId;
import com.f12.moitz.infrastructure.dto.KakaoApiResponse;
import com.f12.moitz.infrastructure.dto.LoadStationRequest;
import com.f12.moitz.infrastructure.repository.CategoryRepository;
import com.f12.moitz.infrastructure.repository.LoadInfoRepository;
import com.f12.moitz.infrastructure.repository.StationCategoryCountRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoadInfoService {

    private final LoadInfoRepository loadInfoRepository;
    private final CategoryRepository categoryRepository;
    private final StationCategoryCountRepository stationCategoryCountRepository;
    private final KakaoMapClient kakaoMapClient;

    public void save(LoadStationRequest request) {
        Station station = Station.beforeSave(request.name(), request.longitude(), request.latitude(), request.isPopular());
        loadInfoRepository.save(station);
    }

    public void save2() {
        List<Station> stations = loadInfoRepository.findAll();

        for (Station station : stations) {
            final KakaoApiResponse kakaoApiResponse = kakaoMapClient.searchPlaceBy(station.getLongitude(), station.getLatitude(), "커피", "CE7");
            final int totalCount = kakaoApiResponse.getTotalCount();



            Category category = categoryRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("hi"));

            StationCategoryCountId id = new StationCategoryCountId(station.getId(), category.getId());
            StationCategoryCount stationCategoryCount = new StationCategoryCount(id, station, category, totalCount);
            stationCategoryCountRepository.save(stationCategoryCount);
        }
    }

    public void save3() {
        Station station = loadInfoRepository.findByName("마두");
        final KakaoApiResponse kakaoApiResponse = kakaoMapClient.searchPlaceBy(station.getLongitude(), station.getLatitude(), "커피", "CE7");
        final int totalCount = kakaoApiResponse.getTotalCount();

        Category category = categoryRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("hi"));

        StationCategoryCountId id = new StationCategoryCountId(station.getId(), category.getId());
        StationCategoryCount stationCategoryCount = new StationCategoryCount(id, station, category, totalCount);
        stationCategoryCountRepository.save(stationCategoryCount);
    }
}
