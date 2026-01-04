package com.github.yun531.weatherdataserver.repository;

import com.github.yun531.weatherdataserver.entity.MidPop;
import com.github.yun531.weatherdataserver.entity.ProvinceRegionCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MidPopRepository extends JpaRepository<MidPop, Long> {
    List<MidPop> findAllByRegionCode(ProvinceRegionCode regionCode);
}
