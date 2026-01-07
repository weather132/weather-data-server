package com.github.yun531.weatherdataserver.service;

import com.github.yun531.weatherdataserver.dto.DailyForecast;
import com.github.yun531.weatherdataserver.dto.DailyForecastItem;
import com.github.yun531.weatherdataserver.entity.CityRegionCode;
import com.github.yun531.weatherdataserver.entity.MidPop;
import com.github.yun531.weatherdataserver.entity.MidTemperature;
import com.github.yun531.weatherdataserver.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("dailyServiceImpl")
public class DailyServiceImpl implements DailyServiceInterface{

    private final CityRegionCodeRepository cityRegionCodeRepository;
    private final ShortLandRepository shortLandRepository;
    private final MidPopRepository midPopRepository;
    private final MidTemperatureRepository midTemperatureRepository;

    @Autowired
    public DailyServiceImpl(CityRegionCodeRepository cityRegionCodeRepository, ShortLandRepository shortLandRepository, MidPopRepository midPopRepository, MidTemperatureRepository midTemperatureRepository) {
        this.cityRegionCodeRepository = cityRegionCodeRepository;
        this.shortLandRepository = shortLandRepository;
        this.midPopRepository = midPopRepository;
        this.midTemperatureRepository = midTemperatureRepository;
    }

    @Override
    public DailyForecast getRecentDailyForecast(String cityRegionCode) {
        CityRegionCode cityRegion = cityRegionCodeRepository.findByRegionCode(cityRegionCode).get();

        List<DailyForecastItem> shortDailyForecasts = shortLandRepository.findRecentByRegionCode(cityRegion).stream()
                .map(DailyForecastItem::new)
                .collect(Collectors.toList());

        List<MidPop> midPops = midPopRepository.findRecentByRegionCode(cityRegion.getProvince_region_code());
        List<MidTemperature> midTemps = midTemperatureRepository.findRecentByRegionCode(cityRegion);

        List<DailyForecastItem> midDailyForecasts = new ArrayList<>();
        for (MidPop midPop : midPops) {
            int efHour = midPop.getEffectiveTime().getHour();

            MidTemperature matchedTemp = midTemps.stream()
                    .filter(midTemp -> midTemp.getEffectiveTime().getDayOfMonth() == midPop.getEffectiveTime().getDayOfMonth())
                    .findFirst()
                    .get();

            midDailyForecasts.add(new DailyForecastItem(
                    midPop.getAnnounceTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                    , midPop.getEffectiveTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                    , efHour == 9 ? matchedTemp.getMinTemp() : matchedTemp.getMaxTemp()
                    , midPop.getPop()));
        }

        shortDailyForecasts.addAll(midDailyForecasts);
        return new DailyForecast(cityRegionCode, shortDailyForecasts);
    }
}
