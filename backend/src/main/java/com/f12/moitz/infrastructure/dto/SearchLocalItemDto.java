package com.f12.moitz.infrastructure.dto;

public record SearchLocalItemDto(
        // 장소 이름 (<b> 태그가 포함될 수 있으므로 클라이언트에서 제거 필요)
        String title,

        // 장소의 네이버 지도 링크
        String link,

        // 장소의 카테고리
        String category,

        // 장소에 대한 설명
        String description,

        // 전화번호
        String telephone,

        // 지번 주소
        String address,

        // 도로명 주소
        String roadAddress,

        // X 좌표 (지도 API에서 사용)
        String mapx,

        // Y 좌표 (지도 API에서 사용)
        String mapy
) {
}
