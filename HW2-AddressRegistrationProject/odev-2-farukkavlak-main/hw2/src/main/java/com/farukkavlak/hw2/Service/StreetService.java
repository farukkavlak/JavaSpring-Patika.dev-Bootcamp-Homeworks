package com.farukkavlak.hw2.Service;

import com.farukkavlak.hw2.Dao.NeighbourhoodDao;
import com.farukkavlak.hw2.Dao.StreetDao;
import com.farukkavlak.hw2.Model.Neighbourhood;
import com.farukkavlak.hw2.Model.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreetService {
    @Autowired
    StreetDao streetDao;

    @Autowired
    NeighbourhoodDao neighbourhoodDao;

    public Street saveStreet(Street street, int belongNeighbourhood_id) {
        Neighbourhood neighbourhood = neighbourhoodDao.findById(belongNeighbourhood_id).orElseThrow();
        neighbourhood.getStreets().add(street);
        return streetDao.save(street);
    }

    public Street updateStreetName(String newName, int street_id) {
        Street street = streetDao.findById(street_id).orElseThrow();
        street.setName(newName);
        return streetDao.save(street);
    }

    public Street getStreet(String streetName) {
        return streetDao.findByName(streetName);
    }

    public boolean isStreetExist(String streetName) {
        if(getStreet(streetName)!=null){
            return true;
        }
        return false;
    }
}
