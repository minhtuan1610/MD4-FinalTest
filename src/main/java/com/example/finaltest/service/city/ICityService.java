package com.example.finaltest.service.city;

import com.example.finaltest.model.City;
import com.example.finaltest.model.Nation;
import com.example.finaltest.service.IGeneralService;

public interface ICityService extends IGeneralService<City> {
    Iterable<City> findAllByNation(Nation nation);
}
