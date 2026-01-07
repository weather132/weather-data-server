package com.github.yun531.weatherdataserver.dto;

import com.github.yun531.weatherdataserver.entity.ShortLand;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class DailyForecastItem {
    private String announceTime;
    private String effectiveTime;
    private Integer temp;
    private Integer pop;

    public DailyForecastItem(ShortLand shortLand) {
        this.announceTime = shortLand.getAnnounceTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.effectiveTime = shortLand.getEffectiveTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.temp = shortLand.getTemp();
        this.pop = shortLand.getPop();
    }
}
