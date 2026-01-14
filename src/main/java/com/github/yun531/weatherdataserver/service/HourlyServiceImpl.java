package com.github.yun531.weatherdataserver.service;

import com.github.yun531.weatherdataserver.dto.HourlyForecastDto;
import com.github.yun531.weatherdataserver.dto.ShortGridForecastData;
import com.github.yun531.weatherdataserver.entity.CityRegionCode;
import com.github.yun531.weatherdataserver.entity.ShortGrid;
import com.github.yun531.weatherdataserver.repository.CityRegionCodeRepository;
import com.github.yun531.weatherdataserver.repository.ShortGridRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service("popServiceImpl")
public class HourlyServiceImpl implements HourlyServiceInterface {
    private final ShortGridRepository shortGridRepository;
    private final CityRegionCodeRepository cityRegionCodeRepository;

    @Autowired
    public HourlyServiceImpl(ShortGridRepository shortGridRepository, CityRegionCodeRepository cityRegionCodeRepository) {
        this.shortGridRepository = shortGridRepository;
        this.cityRegionCodeRepository = cityRegionCodeRepository;
    }

    @Override
    public HourlyForecastDto getSnapshot(String announceTime, Integer x, Integer y) {
        List<ShortGrid> shortGrids = shortGridRepository.findByAnnounceTimeAndXAndY(LocalDateTime.parse(announceTime), x, y);

        List<ShortGridForecastData> shortGridForecastData = shortGrids.stream()
                .map(ShortGridForecastData::new)
                .toList();

        return new HourlyForecastDto(announceTime, x, y, shortGridForecastData);

    }

    @Override
    public HourlyForecastDto getSnapshotWithRegionCode(String announceTime, String regionCode) {
        CityRegionCode cityRegionCode = cityRegionCodeRepository.findByRegionCode(regionCode).get();
        int x = cityRegionCode.getX();
        int y = cityRegionCode.getY();

        return getSnapshot(announceTime, x, y);
    }
}
