package org.fastrackit.Proiectfinal.service;

import org.fastrackit.Proiectfinal.model.City;
import org.fastrackit.Proiectfinal.model.Temperature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component

public class CityReader {
    private final String pathName;

    public CityReader(@Value("${initial.data}") String pathName) {
        this.pathName = pathName;
    }

    public List<City> readCity() {
        List<City> cities = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(pathName));
            long id = 1;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                cities.add(fromLine(line, id++));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cities;
    }

    private City fromLine(String line, long id) {
        System.out.println(line);
        String[] tokens = line.split("\\|");
        City.CityBuilder cityBuilder = City.builder()
                .id(id)
                .name(tokens[0])
                .temperature(new Temperature(tokens[2],Integer.valueOf(tokens[1])));
        return cityBuilder.build();
    }
}