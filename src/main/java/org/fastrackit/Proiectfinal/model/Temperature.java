package org.fastrackit.Proiectfinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Temperature {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String description;
    @Column
    private long temp;
    @JsonIgnore
    @ManyToOne
    private City city;

    public Temperature(String description, long temp) {
        this.description = description;
        this.temp = temp;
    }
}