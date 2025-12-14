package com.github.yun531.weatherdataserver.repository;

import com.github.yun531.weatherdataserver.entity.ShortTemperature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortTemperatureRepository extends JpaRepository<ShortTemperature, Long> {
}
