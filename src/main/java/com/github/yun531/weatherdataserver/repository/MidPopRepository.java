package com.github.yun531.weatherdataserver.repository;

import com.github.yun531.weatherdataserver.entity.MidPop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MidPopRepository extends JpaRepository<MidPop, Long> {
    List<MidPop> findAllByRegionCodeAndAnnounceTime(String regionCode, LocalDateTime announceTime);
}
