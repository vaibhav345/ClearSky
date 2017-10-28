package project.clearSky.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.UUID;

@Entity
public class WeatherInfo {

    @Id
    private String id;
    private String city;
    private String description;
    private int humidity;
    private int pressure;
    private int temperature;
    private String timestamp;

    @OneToOne(cascade = CascadeType.ALL)
    private Wind wind;

    public WeatherInfo() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        Date date = new Date(String.valueOf(timestamp));
        return "WeatherInfo{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", humidity='" + humidity + '\'' +
                ", pressure='" + pressure + '\'' +
                ", temperature='" + temperature + '\'' +
                ", timestamp='" + date + '\'' +
                ", wind=" + wind +
                '}';
    }
}
