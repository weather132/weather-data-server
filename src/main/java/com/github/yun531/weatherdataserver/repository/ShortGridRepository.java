package com.github.yun531.weatherdataserver.repository;

import com.github.yun531.weatherdataserver.entity.ShortGrid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ShortGridRepository extends JpaRepository<ShortGrid, Long> {
    List<ShortGrid> findByAnnounceTimeAndXAndY(LocalDateTime announceTime, Integer x, Integer y);
}
