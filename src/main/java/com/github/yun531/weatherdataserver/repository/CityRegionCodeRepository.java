package com.github.yun531.weatherdataserver.repository;

import com.github.yun531.weatherdataserver.entity.CityRegionCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRegionCodeRepository extends JpaRepository<CityRegionCode, Long> {
    Optional<CityRegionCode> findByRegionCode(String regionCode);
}
