package com.github.yun531.weatherdataserver.dto;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DailyForecast {
    String regionCode;
    List<DailyForecastItem> forecasts;
}
