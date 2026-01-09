package com.github.yun531.weatherdataserver.service;

import com.github.yun531.weatherdataserver.dto.HourlyForecastDto;
import com.github.yun531.weatherdataserver.dto.ShortPopDto;
import com.github.yun531.weatherdataserver.entity.CityRegionCode;
import com.github.yun531.weatherdataserver.entity.ShortPop;
import com.github.yun531.weatherdataserver.repository.CityRegionCodeRepository;
import com.github.yun531.weatherdataserver.repository.ShortPopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service("popServiceImpl")
public class HourlyServiceImpl implements HourlyServiceInterface {
    private final ShortPopRepository shortPopRepository;
    private final CityRegionCodeRepository cityRegionCodeRepository;

    @Autowired
    public HourlyServiceImpl(ShortPopRepository shortPopRepository, CityRegionCodeRepository cityRegionCodeRepository) {
        this.shortPopRepository = shortPopRepository;
        this.cityRegionCodeRepository = cityRegionCodeRepository;
    }

    @Override
    public HourlyForecastDto getSnapshot(String announceTime, Integer x, Integer y) {
        List<ShortPop> pops = shortPopRepository.findAllByAnnounceTimeAndXAndY(LocalDateTime.parse(announceTime), x, y);

        List<ShortPopDto> shortPopDtos = pops.stream()
                .map(sp -> new ShortPopDto(sp.getEffectiveTime(), sp.getPop()))
                .toList();

        return new HourlyForecastDto(announceTime, x, y, shortPopDtos);

    }

    @Override
    public HourlyForecastDto getSnapshotWithRegionCode(String announceTime, String regionCode) {
        CityRegionCode cityRegionCode = cityRegionCodeRepository.findByRegionCode(regionCode).get();
        int x = cityRegionCode.getX();
        int y = cityRegionCode.getY();

        return getSnapshot(announceTime, x, y);
    }
}
