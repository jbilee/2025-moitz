package com.f12.moitz.infrastructure.service;

import com.f12.moitz.common.MidPointCalculator;
import com.f12.moitz.infrastructure.OdsayClient;
import com.f12.moitz.infrastructure.domain.Station;
import com.f12.moitz.infrastructure.repository.LoadInfoRepository;
import com.f12.moitz.ui.dto.PlaceRequest;
import com.f12.moitz.ui.dto.SearchResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MidPointService {

    private final OdsayClient odsayClient;
    private final LoadInfoRepository loadInfoRepository;

    public SearchResponse searchRecommendationMap(final List<String> stations) {
        List<Station> startingStations = getStartingStations(stations);
        PlaceRequest midPointPLace = getSearchMidPointPlace(startingStations);
        List<Station> midPointStations = getSearchMidPointStations(midPointPLace);
        return getRecommandationStation(startingStations,midPointStations);
    }

    private List<Station> getStartingStations(final List<String> stations) {
        List<Station> startingStations = new ArrayList<>();
        for(String stationName : stations){
            startingStations.add(loadInfoRepository.findByName(stationName));
        }
        return startingStations;
    }

    private PlaceRequest getSearchMidPointPlace(final List<Station> startingStations) {
        List<PlaceRequest> placeRequests = new ArrayList<>();
        for(Station station : startingStations){
            placeRequests.add(new PlaceRequest(station.getLatitude(),station.getLongitude()));
        }
        return MidPointCalculator.calculateCenterPoint(placeRequests);
    }

    private List<Station> getSearchMidPointStations(final PlaceRequest midPointPLace) {
        return loadInfoRepository.selectAllMidPointStations(midPointPLace.latitude(),midPointPLace.longitude());
    }

    private SearchResponse getRecommandationStation(final List<Station> startingStations, final List<Station> midPointStations) {
        for()
        odsayClient.calculateTravelTime(midPointStations);
    }
}
