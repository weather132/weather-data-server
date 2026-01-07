package com.github.yun531.weatherdataserver.service;

import com.github.yun531.weatherdataserver.dto.DailyForecast;

public interface DailyServiceInterface {
    DailyForecast getRecentDailyForecast(String regionCode);
}
