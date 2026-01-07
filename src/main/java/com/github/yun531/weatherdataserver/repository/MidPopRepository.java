package com.github.yun531.weatherdataserver.repository;

import com.github.yun531.weatherdataserver.entity.MidPop;
import com.github.yun531.weatherdataserver.entity.ProvinceRegionCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MidPopRepository extends JpaRepository<MidPop, Long> {
    List<MidPop> findAllByRegionCode(ProvinceRegionCode regionCode);

    default List<MidPop> findRecentByRegionCode(ProvinceRegionCode regionCode) {
        List<MidPop> midPops = findAllByRegionCode(regionCode);
        LocalDateTime recentAnnounceTime = midPops.stream()
                .map(MidPop::getAnnounceTime)
                .reduce((time1, time2) -> time1.isAfter(time2) ? time1 : time2)
                .get();

        return midPops.stream()
                .filter(midPop -> midPop.getAnnounceTime().isEqual(recentAnnounceTime))
                .toList();
    }
}
