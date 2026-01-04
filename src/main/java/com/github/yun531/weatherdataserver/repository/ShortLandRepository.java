package com.github.yun531.weatherdataserver.repository;

import com.github.yun531.weatherdataserver.entity.CityRegionCode;
import com.github.yun531.weatherdataserver.entity.ShortLand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShortLandRepository extends JpaRepository<ShortLand, Long> {
    List<ShortLand> findByRegionCode(CityRegionCode regionCode);
}
