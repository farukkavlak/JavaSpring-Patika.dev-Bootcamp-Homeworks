package com.farukkavlak.hw2.Model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "AddressTable")
@Getter
@Setter
@RequiredArgsConstructor
public class Address {
    @Id
    @SequenceGenerator(name = "Address",sequenceName = "address_id_seq")
    @GeneratedValue(generator = "Address")
    private Integer id;

    @Column(name = "doorNo" ,nullable = false)
    private int doorNo;

    @Column(name = "homeNo" ,nullable = false)
    private int homeNo;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Country.class)
    @JoinColumn(name = "address_country_fk",referencedColumnName = "id")
    private Country country;
    
    @JoinColumn(name = "address_city_fk",referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = City.class)
    private City city;
    
    @JoinColumn(name = "address_district_fk",referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = District.class)
    private District district;

    @JoinColumn(name = "address_neighborhood_fk",referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Neighbourhood.class)
    private Neighbourhood neighbourhood;

    @JoinColumn(name = "address_street_fk",referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Street.class)
    private Street street;
}
