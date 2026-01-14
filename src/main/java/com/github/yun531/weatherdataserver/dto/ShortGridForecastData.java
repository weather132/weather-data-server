package com.github.yun531.weatherdataserver.dto;

import com.github.yun531.weatherdataserver.entity.ShortGrid;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class ShortGridForecastData {
    private String effectiveTime;
    private Integer pop;
    private Integer maxTemp;
    private Integer minTemp;

    public ShortGridForecastData(LocalDateTime effectiveTime, Integer pop,  Integer maxTemp, Integer minTemp) {
        this.effectiveTime = effectiveTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.pop = pop;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public ShortGridForecastData(ShortGrid shortGrid) {
        this.effectiveTime = shortGrid.getEffectiveTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.pop = shortGrid.getPop();
        this.maxTemp = shortGrid.getMaxTemp();
        this.minTemp = shortGrid.getMinTemp();
    }
}