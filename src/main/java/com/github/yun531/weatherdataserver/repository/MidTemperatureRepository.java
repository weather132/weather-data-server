package com.github.yun531.weatherdataserver.repository;

import com.github.yun531.weatherdataserver.entity.CityRegionCode;
import com.github.yun531.weatherdataserver.entity.MidTemperature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MidTemperatureRepository extends JpaRepository<MidTemperature, Long> {
    List<MidTemperature> findAllByRegionCode(CityRegionCode regionCode);
}
