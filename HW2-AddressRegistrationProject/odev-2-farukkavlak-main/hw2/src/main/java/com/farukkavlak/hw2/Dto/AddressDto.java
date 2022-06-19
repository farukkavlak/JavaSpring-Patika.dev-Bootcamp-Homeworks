package com.farukkavlak.hw2.Dto;

import lombok.Data;

//To show details about Address to User
@Data
public class AddressDto {
    private int doorNo;
    private int homeNo;
    private String countryName;
    private String cityName;
    private String districtName;
    private String neighbourhoodName;
    private String streetName;
}
