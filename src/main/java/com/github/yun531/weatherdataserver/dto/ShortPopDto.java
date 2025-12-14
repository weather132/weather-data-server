package com.github.yun531.weatherdataserver.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class ShortPopDto {
    private String effectiveTime;
    private Integer pop;

    public ShortPopDto(LocalDateTime effectiveTime, Integer pop) {
        this.effectiveTime = effectiveTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.pop = pop;
    }
}