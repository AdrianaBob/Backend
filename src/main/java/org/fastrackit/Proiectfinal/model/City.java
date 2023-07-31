package org.fastrackit.Proiectfinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity

public class City {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "city_name")
    private String name;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Temperature temperature;

    public City(long id) {
        this.id = id;
    }
}