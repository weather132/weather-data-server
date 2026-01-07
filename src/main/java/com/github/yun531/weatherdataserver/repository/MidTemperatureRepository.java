package com.github.yun531.weatherdataserver.repository;

import com.github.yun531.weatherdataserver.entity.CityRegionCode;
import com.github.yun531.weatherdataserver.entity.MidTemperature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MidTemperatureRepository extends JpaRepository<MidTemperature, Long> {
    List<MidTemperature> findAllByRegionCode(CityRegionCode regionCode);

    default List<MidTemperature> findRecentByRegionCode(CityRegionCode regionCode) {
        List<MidTemperature> midTemps = findAllByRegionCode(regionCode);
        LocalDateTime recentAnnounceTime = midTemps.stream()
                .map(MidTemperature::getAnnounceTime)
                .reduce((time1, time2) -> time1.isAfter(time2) ? time1 : time2)
                .get();

        return midTemps.stream()
                .filter(midTemp -> midTemp.getAnnounceTime().isEqual(recentAnnounceTime))
                .toList();
    }
}
