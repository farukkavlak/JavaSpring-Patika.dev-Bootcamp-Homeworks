package com.farukkavlak.hw2.Service;

import com.farukkavlak.hw2.Dao.DistrictDao;
import com.farukkavlak.hw2.Dao.NeighbourhoodDao;
import com.farukkavlak.hw2.Model.District;
import com.farukkavlak.hw2.Model.Neighbourhood;
import com.farukkavlak.hw2.Model.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class NeighbourhoodService {
    @Autowired
    private NeighbourhoodDao neighbourhoodDao;

    @Autowired
    private DistrictDao districtDao;

    public Neighbourhood saveNeighbourhood(Neighbourhood neighbourhood, int belongDistrictId) {
        District district = districtDao.findById(belongDistrictId).orElseThrow();
        district.getNeighbourhoods().add(neighbourhood);
        return neighbourhoodDao.save(neighbourhood);
    }

    public Neighbourhood updateNeighbourhoodName(String newName, int neighbourhood_id) {
        Neighbourhood neighbourhood = neighbourhoodDao.findById(neighbourhood_id).orElseThrow();
        neighbourhood.setName(newName);
        return neighbourhoodDao.save(neighbourhood);
    }

    public List<Street> getStreetsBelongToNeighbourhood(int belongNeighbourhood_id) {
        return neighbourhoodDao.findById(belongNeighbourhood_id).orElseThrow().getStreets();
    }

    public Neighbourhood getNeighbourhood(String neighbourhoodName) {
        return neighbourhoodDao.findByName(neighbourhoodName);
    }

    public boolean isNeighbourhoodExist(String neighbourhoodName) {
        if(getNeighbourhood(neighbourhoodName)!=null){
            return true;
        }
        return false;
    }
}
