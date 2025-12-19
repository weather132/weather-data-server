package com.github.yun531.weatherdataserver.service;

import com.github.yun531.weatherdataserver.dto.DailyForecast;

import java.time.LocalDateTime;

public interface DailyServiceInterface {
    DailyForecast getDailyForecast(String regionCode, LocalDateTime announceTime);

}
