package project.clearSky.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;
import project.clearSky.constant.URI;
import project.clearSky.entity.WeatherInfo;
import project.clearSky.service.WeatherInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = URI.WEATHERINFO)
public class WeatherInfoController {

    private WeatherInfoService weatherInfoService;

    public WeatherInfoController(WeatherInfoService weatherInfoService) {
        this.weatherInfoService = weatherInfoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Find All Weather_Info", notes = "Returns a list of Weather_Info in the app")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal Server Error"), })
    public List<WeatherInfo> findAll() {
        return weatherInfoService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cities")
    @ApiOperation(value = "Find All Cities", notes = "Returns a list of Cities in the app")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal Server Error"), })
    public Set<String> findAllCities() {
        List<WeatherInfo> weatherInfoList = weatherInfoService.findAll();

        Set<String> allCities = new HashSet<>(); // Set is used to avoid duplication.
        weatherInfoList.forEach(weatherInfo -> allCities.add(weatherInfo.getCity()));

        return allCities;
    }

    @RequestMapping(method = RequestMethod.GET, params = {"city"})
    @ApiOperation(value = "Find Latest Weather by City", notes = "Returns a Latest Weather by City if it exists in the app")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error"), })
    public WeatherInfo findCityLatest( String city) {
        List<WeatherInfo> weatherInfoList = weatherInfoService.findAllByCityOrderByTimestampDesc(city);

        WeatherInfo weatherInfo = weatherInfoList.get(0);

        return weatherInfo;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dailyaverage", params = {"city"})
    @ApiOperation(value = "Find Daily Average by City", notes = "Returns Daily Average by City")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal Server Error"), })
    public List<WeatherInfo> findDailyAverage(String city) {
        List<WeatherInfo> averageList = weatherInfoService.findDaliyAvg(city);

        return averageList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hourlyaverage", params = {"city"})
    @ApiOperation(value = "Find Hourly Average by City", notes = "Returns Hourly Average by City")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal Server Error"), })
    public List<WeatherInfo> findHourlyAverage(String city) {
        List<WeatherInfo> averageList = weatherInfoService.findHourlyAvg(city);

        return averageList;
    }

    @RequestMapping(method = RequestMethod.GET, value = URI.ID)
    @ApiOperation(value = "Find WeatherInfo by Id", notes = "Returns a WeatherInfo object by id if it exists in the app")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error"), })
    public WeatherInfo findOne(@PathVariable("id") String id) {
        return weatherInfoService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Create WeatherInfo", notes = "Creates a WeatherInfo object in the app with unique email")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error"), })
    public WeatherInfo create(@RequestBody WeatherInfo weatherInfo) {
        return weatherInfoService.create(weatherInfo);
    }

    @RequestMapping(method = RequestMethod.PUT, value = URI.ID)
    @ApiOperation(value = "Update WeatherInfo", notes = "Updates an existing WeatherInfo object")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error"), })
    public WeatherInfo update(@PathVariable("id") String id, @RequestBody WeatherInfo weatherInfo) {
        return weatherInfoService.update(id, weatherInfo);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = URI.ID)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error"), })
    @ApiOperation(value = "Delete User", notes = "Deletes an existing WeatherInfo")
    public void delete(@PathVariable("id") String id) {
        weatherInfoService.delete(id);
    }
}
