package org.fastrackit.Proiectfinal.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.fastrackit.Proiectfinal.exception.ResourceNotFoundException;
import org.fastrackit.Proiectfinal.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CityService {
    private final CityReader cityReader;

    private final CityRepository cityRepository;
    private final Temperatureepository temperatureepository;

    @PostConstruct
    public void init() {
        List<City> cities = cityReader.readCity();
        cityRepository.saveAll(cities);
        List<City> cityList = cityRepository.findAll().stream().toList();
        for (City city : cityList) {
            city.getTemperature().setCity(city);
        }
        temperatureepository.saveAll(cityList.stream().map(City::getTemperature).toList());
    }


    public List<City> getAllCity(Long temp, String name) {
        return cityRepository.filterCity(temp, name);
    }

    public List<City> getByTemp(long temp) {
        return cityRepository.findByTempJPQL(temp);
    }
    public City getById(long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("city not found", id));
    }

    public City delete(long id) {
        City city = getById(id);
        cityRepository.deleteById(id);
        return city;
    }

    public City add(City city) {
        cityRepository.save(city);
        return city;
    }

    public City update(City city, long id) {
        return add(City.builder()
                .id(id)
                .name(city.getName())
                .temperature(city.getTemperature())
                .build());
    }

}
