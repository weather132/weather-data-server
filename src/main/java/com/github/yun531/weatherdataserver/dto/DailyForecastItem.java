package com.github.yun531.weatherdataserver.dto;

import lombok.Data;

@Data
public class DailyForecastItem {
    private String effectiveTime;
    private Integer maxTemp;
    private Integer minTemp;
    private Integer pop;
}
