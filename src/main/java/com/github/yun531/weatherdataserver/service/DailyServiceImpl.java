//package com.github.yun531.weatherdataserver.service;
//
//import com.github.yun531.weatherdataserver.dto.DailyForecast;
//import com.github.yun531.weatherdataserver.entity.MidPop;
//import com.github.yun531.weatherdataserver.entity.MidTemperature;
//import com.github.yun531.weatherdataserver.repository.MidPopRepository;
//import com.github.yun531.weatherdataserver.repository.MidTemperatureRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service("dailyServiceImpl")
//public class DailyServiceImpl implements DailyServiceInterface{
//
//    private final MidPopRepository midPopRepository;
//    private final MidTemperatureRepository midTemperatureRepository;
//
//    @Autowired
//    public DailyServiceImpl(MidPopRepository midPopRepository, MidTemperatureRepository midTemperatureRepository) {
//        this.midPopRepository = midPopRepository;
//        this.midTemperatureRepository = midTemperatureRepository;
//    }
//
//    @Override
//    public DailyForecast getDailyForecast(String regionCode, LocalDateTime announceTime) {
//        LocalDateTime maskedAnnounceTime = announceTime.withMinute(0).withSecond(0).withNano(0);
//
//        List<MidTemperature> temps = midTemperatureRepository.findAllByRegionCodeAndAnnounceTime(regionCode, maskedAnnounceTime);
//
//        return
//    }
//}
