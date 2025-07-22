package com.f12.moitz.infrastructure.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
 @NoArgsConstructor
 @AllArgsConstructor
 public class NaverSearchResponse {
             // 검색 결과를 생성한 시간
             private String lastBuildDate;
             // **우리가 원하는 총 검색 결과 개수**
             private int total;
             // 검색 시작 위치
             private int start;
             // 한 번에 표시할 검색 결과 개수
             private int display;

             private List<SearchLocalItemDto> items;
}
