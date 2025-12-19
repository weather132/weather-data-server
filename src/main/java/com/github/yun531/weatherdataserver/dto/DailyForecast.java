package com.github.yun531.weatherdataserver.dto;

import com.github.yun531.weatherdataserver.entity.MidTemperature;

import java.util.List;

public class DailyForecast {
    String announceTime;
    String regionCode;
    List<DailyForecastItem> forecasts;
}
