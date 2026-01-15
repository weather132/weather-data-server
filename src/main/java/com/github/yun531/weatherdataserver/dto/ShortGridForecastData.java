package com.github.yun531.weatherdataserver.dto;

import com.github.yun531.weatherdataserver.entity.ShortGrid;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class ShortGridForecastData {
    private String effectiveTime;
    private Integer pop;
    private Integer temp;

    public ShortGridForecastData(LocalDateTime effectiveTime, Integer pop,  Integer temp) {
        this.effectiveTime = effectiveTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.pop = pop;
        this.temp = temp;
    }

    public ShortGridForecastData(ShortGrid shortGrid) {
        this.effectiveTime = shortGrid.getEffectiveTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.pop = shortGrid.getPop();
        this.temp = shortGrid.getTemp();
    }
}