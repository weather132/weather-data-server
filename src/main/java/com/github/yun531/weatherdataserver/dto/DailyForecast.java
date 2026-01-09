package com.github.yun531.weatherdataserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DailyForecast {
    String regionCode;
    List<DailyForecastItem> forecasts;
}
