package com.github.yun531.weatherdataserver.service;

import com.github.yun531.weatherdataserver.dto.HourlyForecastDto;

public interface HourlyServiceInterface {
    HourlyForecastDto getSnapshot(String announceTime, Integer x, Integer y);
    HourlyForecastDto getSnapshotWithRegionCode(String announceTime, String regionCode);
}
