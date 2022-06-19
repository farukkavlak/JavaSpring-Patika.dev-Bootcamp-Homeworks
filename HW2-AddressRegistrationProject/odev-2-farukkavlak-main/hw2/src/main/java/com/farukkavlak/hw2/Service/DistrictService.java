package com.farukkavlak.hw2.Service;

import com.farukkavlak.hw2.Dao.CityDao;
import com.farukkavlak.hw2.Dao.DistrictDao;
import com.farukkavlak.hw2.Model.City;
import com.farukkavlak.hw2.Model.District;
import com.farukkavlak.hw2.Model.Neighbourhood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DistrictService {
    @Autowired
    private DistrictDao districtDao;

    @Autowired
    private CityDao cityDao;

    public District saveDistrict(District district,int belongCityPlateNo) {
        City city = cityDao.findByPlateNo(belongCityPlateNo);
        city.getDistricts().add(district);
        return districtDao.save(district);
    }
    public List<Neighbourhood> getNeighbourhoodsBelongToDistrict(int belongDistrict_id){
        return districtDao.findById(belongDistrict_id).orElseThrow().getNeighbourhoods();
    }

    public District getDistrict(String districtName) {
        return districtDao.findByName(districtName);
    }

    public boolean isDistrictExist(String districtName) {
        if(getDistrict(districtName)!=null){
            return true;
        }
        return false;
    }
}
