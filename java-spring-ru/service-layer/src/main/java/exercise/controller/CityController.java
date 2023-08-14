package exercise.controller;
import exercise.model.City;
import exercise.repository.CityRepository;
import exercise.service.WeatherService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class CityController {

    private final CityRepository cityRepository;

    private final WeatherService weatherService;

    // BEGIN
    @GetMapping(path = "/cities/{id}")
    public Map<String, String> getCityWeather(@PathVariable("id") long id) {
        return weatherService.getWeather(id);
    }

    @GetMapping(path = "/search")
    public List<Map<String, String>> getCitiesWeather(@RequestParam(required = false) String name) {

        List<City> cities;

        if (name == null) {
            cities = cityRepository.findAllByOrderByName();
        } else {
            cities = cityRepository.findByNameStartingWithIgnoreCase(name);
        }

        List<Map<String, String>> citiesWeather = cities.stream()
                .map(city -> {
                    Map<String, String> weather = weatherService.getWeather(city.getId());
                    return Map.of(
                            "temperature", weather.get("temperature"),
                            "name", city.getName()
                    );
                })
                .toList();

        return citiesWeather;
    }
    // END
}

