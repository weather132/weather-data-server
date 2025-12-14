package com.github.yun531.weatherdataserver.service;

import com.github.yun531.weatherdataserver.dto.HourlyForecastDto;
import com.github.yun531.weatherdataserver.dto.ShortPopDto;
import com.github.yun531.weatherdataserver.entity.ShortPop;
import com.github.yun531.weatherdataserver.repository.ShortPopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service("popServiceImpl")
public class PopServiceImpl implements PopServiceInterface {
    private final ShortPopRepository shortPopRepository;

    @Autowired
    public PopServiceImpl(ShortPopRepository shortPopRepository) {
        this.shortPopRepository = shortPopRepository;
    }

    @Override
    public HourlyForecastDto getSnapshot(String announceTime, Integer x, Integer y) {
        List<ShortPop> pops = shortPopRepository.findAllByAnnounceTimeAndXAndY(LocalDateTime.parse(announceTime), x, y);

        List<ShortPopDto> shortPopDtos = pops.stream()
                .map(sp -> new ShortPopDto(sp.getEffectiveTime(), sp.getPop()))
                .toList();

        return new HourlyForecastDto(announceTime, x, y, shortPopDtos);

    }
}
