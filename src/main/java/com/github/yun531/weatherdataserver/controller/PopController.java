package com.github.yun531.weatherdataserver.controller;

import com.github.yun531.weatherdataserver.dto.HourlyForecastDto;
import com.github.yun531.weatherdataserver.service.PopServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/pop")
public class PopController {
    private PopServiceInterface popService;

    @Autowired
    public void setPopService(@Qualifier("popServiceImpl") PopServiceInterface popService) {
        this.popService = popService;
    }

    @GetMapping("/snapshot")
    public HourlyForecastDto getSnapshot(@RequestParam(value = "announceTime", required = false) String nullableAnnounceTime,
                                               @RequestParam(value = "x") Integer x,
                                               @RequestParam(value = "y") Integer y) {

        String announceTime = nullableAnnounceTime == null ? formatTime(getLatestAnnounceTime()) : nullableAnnounceTime;

        return popService.getSnapshot(announceTime, x, y);
    }


    private LocalDateTime getLatestAnnounceTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.minusHours((now.getHour() + 1) % 3).withMinute(0).withSecond(0).withNano(0);
    }

    private String formatTime(LocalDateTime time) {
        return time.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
