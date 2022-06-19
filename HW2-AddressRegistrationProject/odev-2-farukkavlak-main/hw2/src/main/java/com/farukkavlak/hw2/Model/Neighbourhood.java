package com.farukkavlak.hw2.Model;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "NeighbourhoodTable")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Neighbourhood {
    @Id
    @SequenceGenerator(name = "Neighbourhood",sequenceName = "neighbourhood_id_seq")
    @GeneratedValue(generator = "Neighbourhood")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,targetEntity = Street.class)
    @JoinColumn(name = "neighborhood_street_fk", referencedColumnName = "id")
    public List<Street> streets = new ArrayList<Street>();

    public Neighbourhood(String neighbourhoodName) {
        this.name = neighbourhoodName;
    }
}
