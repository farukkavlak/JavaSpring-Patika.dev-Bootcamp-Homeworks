package com.farukkavlak.hw2.Service;

import com.farukkavlak.hw2.Controller.AddressController;
import com.farukkavlak.hw2.Converter.AddressConverter;
import com.farukkavlak.hw2.Dao.AddressDao;
import com.farukkavlak.hw2.Dto.AddressDto;
import com.farukkavlak.hw2.Dto.AddressSaveRequestDto;
import com.farukkavlak.hw2.Model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressDao addressDao;

    //Convert saveRequestDto -> Address ,then save to repo
    public AddressDto saveAddress(AddressSaveRequestDto addressSaveRequestDto, AddressController controller) {
        AddressConverter addressConverter = new AddressConverter(controller);
        Address address = addressConverter.convertToAddress(addressSaveRequestDto);
        addressDao.save(address);
        return addressConverter.convertToAddressDto(address);
    }

    public void deleteAddress(int address_id) {
        addressDao.deleteById(address_id);
    }

    public AddressDto getAddress(int address_id) {
        AddressConverter addressConverter = new AddressConverter();
        AddressDto addressDto = addressConverter.convertToAddressDto(addressDao.findById(address_id).orElseThrow());
        return addressDto;
    }
}
