package com.f12.moitz.infrastructure.repository;

import com.f12.moitz.infrastructure.domain.Station;
import com.f12.moitz.ui.dto.PlaceRequest;
import java.util.List;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadInfoRepository extends JpaRepository<Station, Long> {

    @Query(
            value = """
        SELECT * FROM station 
        WHERE ST_DWithin(
            geography(ST_MakePoint(longitude, latitude)),
            geography(ST_MakePoint(:x, :y)),
            3000
        )
        """,
            nativeQuery = true
    )
    List<Station> selectAllMidPointStations(@Param("y") double y, @Param("x") double x);

    Station findByName(String name);
}
