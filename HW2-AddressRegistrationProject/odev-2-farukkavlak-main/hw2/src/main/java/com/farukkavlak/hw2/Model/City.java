package com.farukkavlak.hw2.Model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "CityTable")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City{
        
    @Id
    @SequenceGenerator(name = "City",sequenceName = "city_id_seq")
    @GeneratedValue(generator = "City")
    private Integer id;

    @Column(nullable = false)
    private int plateNo;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,targetEntity = District.class)
    @JoinColumn(name = "city_district_fk", referencedColumnName = "id")
    public List<District> districts = new ArrayList<District>();

    public City(String cityName, int plateNo) {
        this.name = cityName;
        this.plateNo = plateNo;
    }
}
