package com.github.yun531.weatherdataserver.repository;

import com.github.yun531.weatherdataserver.entity.ShortPop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ShortPopRepository extends JpaRepository<ShortPop, Long> {
    List<ShortPop> findAllByAnnounceTimeAndXAndY(LocalDateTime announceTime, Integer x, Integer y);
}
