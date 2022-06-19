# Odev 2 teslim tarihi : 13 Haziran 23:00 
Address Registration System;<br>
TODO/Features
- [X] Save Country
- [X] Get Country by CountryID
- [X] Save City
- [X] Get City by Plate No
- [X] Save District
- [X] Get Districts Belonging to a City
- [X] Save Neighborhood
- [X] Update Neighborhood Name
- [X] Get Neighborhoods Belonging to a District
- [X] Save Street
- [X] Update Street Name
- [X] Get Streets Belonging to a Neighborhood
- [X] Save Address
- If one of the parameters of the given address exists in the database, only save is done, otherwise that parameter(country,city etc.) is created and then saved.
- [X] Delete Address
- [X] Get Address by AddressID
<br><br>Dto used for only address.
Entity used to get other inputs such as Country,City etc.<br>
Converter class used for convert to Address from AddressSaveRequestDto and to AddressDto from Address.<br>
# Controller
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/Controller.png"></img>
# Schemas
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/Schemas.png"></img>

## Address
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/Address/saveAddress.png"></img>
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/Address/getAddress.png"></img>
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/Address/deleteAddress.png"></img>

## City
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/City/saveCity.png"></img>
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/City/getCity.png"></img>

## Country
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/Country/saveCountry.png"></img>
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/Country/getCountry.png"></img>

## District
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/District/saveDistrict.png"></img>
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/District/saveDistrict2.png"></img>
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/District/getDistrictsBelongToCity.png"></img>

## Neighbourhood
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/Neighbourhood/saveNeighbourhood.png"></img>
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/Neighbourhood/saveNeighbourhood2.png"></img>
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/Neighbourhood/updateNeighbourhoodName.png"></img>
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/Neighbourhood/getNeighbourhoodsBelongToDistrict.png"></img>

## Street
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/Street/saveStreet.png"></img>
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/Street/saveStreet2.png"></img>
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/Street/updateStreetName.png"></img>
<img src="https://github.com/198-MobileAction-Java-Spring-Bootcamp/odev-2-farukkavlak/blob/main/SwaggerUI/Street/getStreetsBelongToNeighbourhood.png"></img>
