package org.fastrackit.Proiectfinal.controller.country;

import lombok.RequiredArgsConstructor;
import org.fastrackit.Proiectfinal.model.City;
import org.fastrackit.Proiectfinal.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("cities")
public class CityController {
    private final CityService cityService;

    @GetMapping
    public List<City> getAll(@RequestParam(required = false) Long temp,
                             @RequestParam(required = false) String name) {
        return cityService.getAllCity(temp, name);
    }

    @GetMapping("/{id}")
    public City getById(@PathVariable long id) {
        return cityService.getById(id);
    }

    @DeleteMapping("/{id}")
    public City deleteById(@PathVariable long id) {
        return cityService.delete(id);
    }

    @PostMapping
    public City addNewCity(@RequestBody City city) {
        return cityService.add(city);
    }

    @PutMapping("/{id}")
    public City updateCity(@RequestBody City city, @PathVariable long id) {
        return cityService.update(city, id);
    }

}
