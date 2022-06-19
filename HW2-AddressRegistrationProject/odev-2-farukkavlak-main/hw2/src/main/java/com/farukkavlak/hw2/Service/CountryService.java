package com.farukkavlak.hw2.Service;

import com.farukkavlak.hw2.Dao.CountryDao;
import com.farukkavlak.hw2.Model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @Autowired
    private CountryDao countryDao;

    public Country saveCountry(Country country) {
        return countryDao.save(country);
    }

    public Country getCountryByCountryCode(int CountryCode) {
        return countryDao.findByCountryCode(CountryCode);
    }
    public boolean isCountryExist(int countryCode){
        if(getCountryByCountryCode(countryCode)!=null){
            return true;
        }
        return false;
    }
}
