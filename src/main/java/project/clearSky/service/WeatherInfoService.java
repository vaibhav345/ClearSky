package project.clearSky.service;

import project.clearSky.entity.WeatherInfo;

import java.util.List;

public interface WeatherInfoService {
    public List<WeatherInfo> findAll();

    public WeatherInfo findOne(String id);

    public WeatherInfo create(WeatherInfo weatherInfo);

    public WeatherInfo update(String id, WeatherInfo weatherInfo);

    public void delete(String id);

    public List<WeatherInfo> findAllByCity(String city);

    public List<WeatherInfo> findAllByCityOrderByTimestampDesc(String city);

    public List<WeatherInfo> findDaliyAvg(String city);

    public List<WeatherInfo> findHourlyAvg(String city);
}
