package com.github.yun531.weatherdataserver.repository;

import com.github.yun531.weatherdataserver.entity.CityRegionCode;
import com.github.yun531.weatherdataserver.entity.ShortLand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ShortLandRepository extends JpaRepository<ShortLand, Long> {
    List<ShortLand> findAllByRegionCode(CityRegionCode regionCode);

    default List<ShortLand> findRecentByRegionCode(CityRegionCode regionCode) {
        List<ShortLand> shortLands = findAllByRegionCode(regionCode);

        LocalDateTime recentAnnounceTime = shortLands.stream()
                .map(ShortLand::getAnnounceTime)
                .reduce((time1, time2) -> time1.isAfter(time2) ? time1 : time2)
                .get();

        return shortLands.stream()
                .filter(land -> land.getAnnounceTime().isEqual(recentAnnounceTime))
                .toList();
    }
}
