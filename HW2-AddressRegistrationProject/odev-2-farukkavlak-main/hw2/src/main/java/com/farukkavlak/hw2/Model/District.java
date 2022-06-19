package com.farukkavlak.hw2.Model;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "DistrictTable")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class District {
    @Id
    @SequenceGenerator(name = "District",sequenceName = "district_id_seq")
    @GeneratedValue(generator = "District")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,targetEntity = Neighbourhood.class)
    @JoinColumn(name = "district_neighborhood_fk", referencedColumnName = "id")
    public List<Neighbourhood> neighbourhoods = new ArrayList<Neighbourhood>();

    public District(String districtName) {
        this.name = districtName;
    }
}
