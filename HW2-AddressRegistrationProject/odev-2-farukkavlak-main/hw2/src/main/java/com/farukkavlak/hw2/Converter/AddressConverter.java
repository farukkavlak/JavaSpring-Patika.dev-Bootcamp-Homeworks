package com.farukkavlak.hw2.Converter;

import com.farukkavlak.hw2.Controller.AddressController;
import com.farukkavlak.hw2.Dao.*;
import com.farukkavlak.hw2.Dto.AddressDto;
import com.farukkavlak.hw2.Dto.AddressSaveRequestDto;
import com.farukkavlak.hw2.Model.*;
import com.farukkavlak.hw2.Dao.CountryDao;
import com.farukkavlak.hw2.Service.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AddressConverter {

    //Repositories
    private CityService cityService;
    private CountryService countryService;
    private StreetService streetService;
    private DistrictService districtService;
    private NeighbourhoodService neighbourhoodService;

    public AddressController controller;
    public AddressConverter(AddressController controller){
        this.controller = controller;
        this.countryService = controller.countryService;
        this.cityService = controller.cityService;
        this.districtService = controller.districtService;
        this.neighbourhoodService = controller.neighbourhoodService;
        this.streetService = controller.streetService;
    }
    public AddressConverter(){

    }
    //AddressSaveRequestDto -> Address
    public Address convertToAddress(AddressSaveRequestDto addressSaveRequestDto) {
        Address address = new Address();
        saveCountryToAddress(addressSaveRequestDto, address);
        saveCityToAddress(addressSaveRequestDto, address);
        saveDistrictToAddress(addressSaveRequestDto, address);
        saveNeighbourhoodToAddress(addressSaveRequestDto, address);
        saveStreetToAddress(addressSaveRequestDto, address);
        address.setDoorNo(addressSaveRequestDto.getDoorNo());
        address.setHomeNo(addressSaveRequestDto.getHomeNo());
        return address;
    }

    private void saveStreetToAddress(AddressSaveRequestDto addressSaveRequestDto, Address address) {
        //Control this street exists in database
        //if exist set this street to address
        //Else create/save this street, then set this street to address
        if(streetService.isStreetExist(addressSaveRequestDto.getStreetName())){
            address.setStreet(streetService.getStreet(addressSaveRequestDto.getStreetName()));
        }else {
            Street street = new Street(addressSaveRequestDto.getStreetName());
            streetService.saveStreet(street,neighbourhoodService.getNeighbourhood(addressSaveRequestDto.getNeighbourhoodName()).getId());
            address.setStreet(street);
        }
    }

    private void saveNeighbourhoodToAddress(AddressSaveRequestDto addressSaveRequestDto, Address address) {
        //Control this neighbourhood exists in database
        //if exist set this neighbourhood to address
        //Else create/save this neighbourhood, then set this neighbourhood to address
        if(neighbourhoodService.isNeighbourhoodExist(addressSaveRequestDto.getNeighbourhoodName())){
            address.setNeighbourhood(neighbourhoodService.getNeighbourhood(addressSaveRequestDto.getNeighbourhoodName()));
        }
        else {
            Neighbourhood neighbourhood = new Neighbourhood(addressSaveRequestDto.getNeighbourhoodName());
            neighbourhoodService.saveNeighbourhood(neighbourhood,districtService.getDistrict(addressSaveRequestDto.getDistrictName()).getId());
            address.setNeighbourhood(neighbourhood);
        }
    }

    private void saveDistrictToAddress(AddressSaveRequestDto addressSaveRequestDto, Address address) {
        //Control this district exists in database
        //if exist set this district to address
        //Else create/save this district, then set this district to address
        if(districtService.isDistrictExist(addressSaveRequestDto.getDistrictName())){
            address.setDistrict(districtService.getDistrict(addressSaveRequestDto.getDistrictName()));
        }else {
            District district = new District(addressSaveRequestDto.getDistrictName());
            districtService.saveDistrict(district, addressSaveRequestDto.getPlateNo());
            address.setDistrict(district);
        }
    }

    private void saveCityToAddress(AddressSaveRequestDto addressSaveRequestDto, Address address) {
        //Control this city exists in database
        //if exist set this city to address
        //Else create/save this city, then set this city to address
        if(cityService.isCityExist(addressSaveRequestDto.getPlateNo())){
            address.setCity(cityService.getCityByPlateNo(addressSaveRequestDto.getPlateNo()));
        }else{
            City city = new City(addressSaveRequestDto.getCityName(), addressSaveRequestDto.getPlateNo());
            cityService.saveCity(city, addressSaveRequestDto.getCountryCode());
            address.setCity(city);
        }
    }


    private void saveCountryToAddress(AddressSaveRequestDto addressSaveRequestDto, Address address) {
        //Control this country exists in database
        //if exist set this country to address
        //Else create/save this country, then set this country to address
        if(countryService.isCountryExist(addressSaveRequestDto.getCountryCode())){
            address.setCountry(countryService.getCountryByCountryCode(addressSaveRequestDto.getCountryCode()));
        }else {
            Country country = new Country(addressSaveRequestDto.getCountryCode(), addressSaveRequestDto.getCountryName());
            countryService.saveCountry(country);
            address.setCountry(country);
        }
    }


    //Address -> AddressDto // to show details about address to user
    public AddressDto convertToAddressDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCityName(address.getCity().getName());
        addressDto.setCountryName(address.getCity().getName());
        addressDto.setDistrictName(address.getDistrict().getName());
        addressDto.setNeighbourhoodName(address.getNeighbourhood().getName());
        addressDto.setStreetName(address.getStreet().getName());
        addressDto.setDoorNo(address.getDoorNo());
        addressDto.setHomeNo(address.getHomeNo());
        return addressDto;
    }
}
