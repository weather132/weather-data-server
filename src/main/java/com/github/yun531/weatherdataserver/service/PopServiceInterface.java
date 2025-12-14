package com.github.yun531.weatherdataserver.service;

import com.github.yun531.weatherdataserver.dto.HourlyForecastDto;

public interface PopServiceInterface {
    HourlyForecastDto getSnapshot(String announceTime, Integer x, Integer y);
}
