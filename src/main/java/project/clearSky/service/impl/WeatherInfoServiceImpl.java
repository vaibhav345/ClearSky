package project.clearSky.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.clearSky.dao.WeatherInfoDao;
import project.clearSky.entity.WeatherInfo;
import project.clearSky.exception.NotFoundException;
import project.clearSky.service.WeatherInfoService;

@Service
public class WeatherInfoServiceImpl implements WeatherInfoService{

    private WeatherInfoDao weatherInfoDao;

    public WeatherInfoServiceImpl(WeatherInfoDao weatherInfoDao) {
        this.weatherInfoDao = weatherInfoDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<WeatherInfo> findAll() {
        return weatherInfoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public WeatherInfo findOne(String id) {
        return weatherInfoDao.findOne(id)
                .orElseThrow(() -> new NotFoundException("Weather Info with id " + id + " does not exist"));
    }

    @Override
    @Transactional
    public WeatherInfo create(WeatherInfo weatherInfo) {
        return weatherInfoDao.save(weatherInfo);
    }

    @Override
    @Transactional
    public WeatherInfo update(String id, WeatherInfo weatherInfo) {
        weatherInfoDao.findOne(id).orElseThrow(() -> new NotFoundException("Weather Info with id " + id + " does not exist"));
        return weatherInfoDao.save(weatherInfo);
    }

    @Override
    @Transactional
    public void delete(String id) {
        WeatherInfo existing = weatherInfoDao.findOne(id)
                .orElseThrow(() -> new NotFoundException("Weather Info with id " + id + " does not exist"));
        weatherInfoDao.delete(existing);
    }

    @Override
    public List<WeatherInfo> findAllByCity(String city) {
        return weatherInfoDao.findAllByCity(city);
    }


    @Override
    public List<WeatherInfo> findAllByCityOrderByTimestampDesc(String city) {
        return weatherInfoDao.findAllByCityOrderByTimestampDesc(city);
    }
    @Override
    public List<WeatherInfo> findDaliyAvg(String city){
        return weatherInfoDao.findDaliyAvg(city);
    }

    @Override
    public List<WeatherInfo> findHourlyAvg(String city) {
        return weatherInfoDao.findHourlyAvg(city);
    }

}
