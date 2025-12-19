package com.github.yun531.weatherdataserver.controller;

import com.github.yun531.weatherdataserver.dto.DailyForecast;
import com.github.yun531.weatherdataserver.service.DailyServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping("/daily")
@RestController
public class DailyController {

    private final DailyServiceInterface dailyService;


    public DailyController(@Qualifier("dailyServiceImpl") DailyServiceInterface dailyService) {
        this.dailyService = dailyService;
    }

    @GetMapping("/forecast")
    public DailyForecast getDailyForecast(@RequestParam String regionCode,
                                          @RequestParam(name = "announceTime", required = false) String nullableAnnounceTime) {

        LocalDateTime announceTime = nullableAnnounceTime == null ? getLatestAnnounceTime() : parseTimeStr(nullableAnnounceTime);

        return dailyService.getDailyForecast(regionCode, announceTime);
    }


    private LocalDateTime getLatestAnnounceTime() {
        LocalDateTime now = LocalDateTime.now();
        int nowHour = now.getHour();
        int announceHour = nowHour >= 6 && nowHour < 18 ? 6 : 8;

        return now.withHour(announceHour).withMinute(0).withSecond(0).withNano(0);
    }

    private LocalDateTime parseTimeStr(String timeStr) {
        return LocalDateTime.parse(timeStr);
    }
}
