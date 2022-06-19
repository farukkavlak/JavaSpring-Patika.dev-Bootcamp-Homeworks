package com.farukkavlak.hw2.Controller;

import com.farukkavlak.hw2.Dto.AddressDto;
import com.farukkavlak.hw2.Dto.AddressSaveRequestDto;
import com.farukkavlak.hw2.Model.*;
import com.farukkavlak.hw2.Service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    //Initialize all services to make operations
    public final CountryService countryService;
    public final CityService cityService;
    public final DistrictService districtService;
    public final NeighbourhoodService neighbourhoodService;
    public final StreetService streetService;
    public final AddressService addressService;


    public AddressController(CountryService countryService,
                             CityService cityService,
                             DistrictService districtService,
                             NeighbourhoodService neighbourhoodService,
                             StreetService streetService,
                             AddressService addressService) {
        this.neighbourhoodService = neighbourhoodService;
        this.districtService = districtService;
        this.countryService = countryService;
        this.cityService = cityService;
        this.streetService = streetService;
        this.addressService = addressService;
    }

    //COUNTRY
    //Save country with given country entity
    @PostMapping("saveCountry")
    public ResponseEntity saveCountry(@RequestBody Country country){
        Country savedCountry = countryService.saveCountry(country);
        return new ResponseEntity(savedCountry, HttpStatus.CREATED);
    }

    //Get country with given country code
    @GetMapping("getCountry/{country_code}")
    public ResponseEntity getCountryByCountryCode(@PathVariable("country_code") int country_code){
        Country country = countryService.getCountryByCountryCode(country_code);
        return ResponseEntity.ok(country);
    }

    //CITY
    //Save city with given city entity
    @PostMapping("saveCity/{country_code}")
    public ResponseEntity saveCity(@RequestBody City city,@PathVariable("country_code") int country_code){
        City savedCity = cityService.saveCity(city,country_code);
        return new ResponseEntity(savedCity, HttpStatus.CREATED);
    }

    //Get city with given plate no
    @GetMapping("getCity/{plate_no}")
    public ResponseEntity getCityByPlateNo(@PathVariable("plate_no") int plate_no){
        City city = cityService.getCityByPlateNo(plate_no);
        return ResponseEntity.ok(city);
    }


    //DISTRICT
    //Save district with given district entity
    @PostMapping("saveDistrict/{belongCity_plateNo}")
    public ResponseEntity saveDistrict(@RequestBody District district,@PathVariable("belongCity_plateNo") int belongCity_plateNo){
        District savedDistrict = districtService.saveDistrict(district,belongCity_plateNo);
        return new ResponseEntity(savedDistrict, HttpStatus.CREATED);
    }

    //Get districts belong to given city with given plate no
    @GetMapping("getDistrictsBelongToCity/{belongCity_plateNo}")
    public ResponseEntity getDistrictsBelongToCity(@PathVariable("belongCity_plateNo") int belongCity_plateNo){
        List<District> districtList = cityService.getDistrictsBelongToCity(belongCity_plateNo);
        return ResponseEntity.ok(districtList);
    }

    //NEIGHBOURHOOD
    //Save neighbourhood with given neighbourhood entity
    @PostMapping("saveNeighbourhood/{belongDistrict_id}")
    public ResponseEntity saveNeighbourhood(@RequestBody Neighbourhood neighbourhood,@PathVariable("belongDistrict_id") int belongDistrict_id){
        Neighbourhood savedNeighbourhood = neighbourhoodService.saveNeighbourhood(neighbourhood,belongDistrict_id);
        return new ResponseEntity(savedNeighbourhood, HttpStatus.CREATED);
    }

    //Update neighbourhood with given neighbourhood id and new name
    @PatchMapping("updateNeighbourhoodName/{neighbourhood_id}")
    public ResponseEntity updateNeighbourhoodName(@RequestBody String newName,@PathVariable("neighbourhood_id") int neighbourhood_id){
        Neighbourhood neighbourhood = neighbourhoodService.updateNeighbourhoodName(newName,neighbourhood_id);
        return ResponseEntity.ok(neighbourhood);
    }

    //Get neighbourhoods belong to given district with given district id
    @GetMapping("getNeighbourhoodsBelongToDistrict/{belongDistrict_id}")
    public ResponseEntity getNeighbourhoodsBelongToDistrict(@PathVariable("belongDistrict_id") int belongDistrict_id){
        List<Neighbourhood> neighbourhoodList = districtService.getNeighbourhoodsBelongToDistrict(belongDistrict_id);
        return ResponseEntity.ok(neighbourhoodList);
    }

    //STREET
    //Save street with given street entity
    @PostMapping("saveStreet/{belongNeighbourhood_id}")
    public ResponseEntity saveStreet(@RequestBody Street street, @PathVariable("belongNeighbourhood_id") int belongNeighbourhood_id){
        Street savedStreet = streetService.saveStreet(street,belongNeighbourhood_id);
        return new ResponseEntity(savedStreet, HttpStatus.CREATED);
    }

    //Update street with given street id and new name
    @PatchMapping("updateStreetName/{street_id}")
    public ResponseEntity updateStreetName(@RequestBody String newName,@PathVariable("street_id") int street_id){
        Street street = streetService.updateStreetName(newName,street_id);
        return ResponseEntity.ok(street);
    }

    //Get streets belong to given neighbourhood with given neighbourhood id
    @GetMapping("getStreetsBelongToNeighbourhood/{belongNeighbourhood_id}")
    public ResponseEntity getStreetsBelongToNeighbourhood(@PathVariable("belongNeighbourhood_id") int belongNeighbourhood_id){
        List<Street> streetList = neighbourhoodService.getStreetsBelongToNeighbourhood(belongNeighbourhood_id);
        return ResponseEntity.ok(streetList);
    }

    //ADDRESS
    //Save address with given address entity
    @PostMapping("saveAddress")
    public ResponseEntity saveAddress(@RequestBody AddressSaveRequestDto addressSaveRequestDto){
        AddressDto addressDto = addressService.saveAddress(addressSaveRequestDto,this);
        return new ResponseEntity(addressDto, HttpStatus.CREATED);
    }

    //Delete address with given address id
    @DeleteMapping("deleteAddress/{address_id}")
    public ResponseEntity deleteAddress(@PathVariable("address_id") int address_id){
        addressService.deleteAddress(address_id);
        return ResponseEntity.ok().build();
    }

    //Get address with given address id
    @GetMapping("getAddress/{address_id}")
    public ResponseEntity getAddress(@PathVariable("address_id") int address_id){
        return ResponseEntity.ok(addressService.getAddress(address_id));
    }


}
