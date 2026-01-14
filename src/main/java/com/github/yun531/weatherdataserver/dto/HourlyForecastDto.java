package com.github.yun531.weatherdataserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class HourlyForecastDto {
    private String announceTime;
    private Integer coordsX;
    private Integer coordsY;
    private List<ShortGridForecastData> gridForecastData;
}
