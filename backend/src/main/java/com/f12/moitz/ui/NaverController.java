package com.f12.moitz.ui;

import com.f12.moitz.infrastructure.NaverSearchClient;
import com.f12.moitz.infrastructure.dto.LoadStationRequest;
import com.f12.moitz.infrastructure.dto.NaverSearchResponse;
import com.f12.moitz.infrastructure.service.LoadInfoService;
import com.f12.moitz.ui.dto.NaverSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NaverController {

    private final NaverSearchClient client;
    private final LoadInfoService loadInfoService;


    @GetMapping("/naver")
    public ResponseEntity<NaverSearchResponse> getNaver(@RequestBody NaverSearchRequest request){
        return ResponseEntity.ok().body(client.searchPlaceBy(request.place(),request.keyword(), request.start()));
    }

    @PostMapping("/station")
    public ResponseEntity<Void> loadStation(@RequestBody LoadStationRequest request){
        loadInfoService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/keyword")
    public ResponseEntity<Void> loadStation(){
        loadInfoService.save3();
        return ResponseEntity.ok().build();
    }

}
