package project.clearSky.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import project.clearSky.entity.WeatherInfo;

import java.util.List;
import java.util.Optional;

public interface WeatherInfoDao extends Repository<WeatherInfo, String>{
    public List<WeatherInfo> findAll();

    public Optional<WeatherInfo> findOne(String id);

    public List<WeatherInfo> findAllByCity(String city);

    public WeatherInfo save(WeatherInfo weatherInfo);

    public void delete(WeatherInfo weatherInfo);

    public List<WeatherInfo> findAllByCityOrderByTimestampDesc(String city);

    @Query("SELECT substring(w.timestamp, 1, 10) , avg(w.temperature) from WeatherInfo w where w.city = ?1 group by substring(w.timestamp, 1, 10) ")
    public List<WeatherInfo> findDaliyAvg(String city);

    @Query("SELECT SUBSTRING(w.timestamp,1,14), AVG(w.temperature) FROM WeatherInfo w where w.city = ?1 GROUP BY SUBSTRING(w.timestamp,1,14)")
    public List<WeatherInfo> findHourlyAvg(String city);

}
