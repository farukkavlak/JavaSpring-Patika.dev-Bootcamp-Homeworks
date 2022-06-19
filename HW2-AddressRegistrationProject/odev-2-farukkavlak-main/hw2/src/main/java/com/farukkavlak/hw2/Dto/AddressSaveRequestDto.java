package com.farukkavlak.hw2.Dto;

import lombok.Data;

//To get information to save Address
@Data
public class AddressSaveRequestDto {
    private String countryName;
    private int countryCode;
    private String cityName;
    private int plateNo;
    private String districtName;
    private String neighbourhoodName;
    private String streetName;
    private int doorNo;
    private int homeNo;
}
