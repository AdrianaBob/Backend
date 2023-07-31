package org.fastrackit.Proiectfinal.service;

import org.fastrackit.Proiectfinal.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByTemperature(Long temp);

    @Query("select t from City t where t.temperature.temp=:temp")
    List<City> findByTempJPQL(@Param("temp") Long temp);

    @Query("select t from City t where (:temp = null or t.temperature.temp=:temp) " +
            "and (:name = null or lower(t.name) like lower(concat('%',:name,'%')))")
    List<City> filterCity(@Param("temp") Long temp,
                          @Param("name") String name);

}
