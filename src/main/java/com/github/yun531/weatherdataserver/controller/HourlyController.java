package com.github.yun531.weatherdataserver.controller;

import com.github.yun531.weatherdataserver.dto.HourlyForecastDto;
import com.github.yun531.weatherdataserver.service.HourlyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/hourly")
public class HourlyController {
    private HourlyServiceInterface popService;

    @Autowired
    public void setPopService(@Qualifier("popServiceImpl") HourlyServiceInterface popService) {
        this.popService = popService;
    }

    @GetMapping("/snapshot")
    public HourlyForecastDto getSnapshot(@RequestParam(value = "announceTime", required = false) String nullableAnnounceTime,
                                               @RequestParam(value = "regionCode") String regionCode) {

        String announceTime = nullableAnnounceTime == null ? formatTime(getLatestAnnounceTime()) : nullableAnnounceTime;

        return popService.getSnapshotWithRegionCode(announceTime, regionCode);
    }


    private LocalDateTime getLatestAnnounceTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.minusHours((now.getHour() + 1) % 3).withMinute(0).withSecond(0).withNano(0);
    }

    private String formatTime(LocalDateTime time) {
        return time.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
