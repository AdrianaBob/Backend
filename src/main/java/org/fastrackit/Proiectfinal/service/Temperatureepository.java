package org.fastrackit.Proiectfinal.service;

import org.fastrackit.Proiectfinal.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Temperatureepository extends JpaRepository<Temperature,Long> {
}
