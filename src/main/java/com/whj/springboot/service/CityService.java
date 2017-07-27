package com.whj.springboot.service;

import com.whj.springboot.domain.City;

/**
 * Created by wuhaijun on 2017/7/22.
 */
public interface CityService {

    public City findCityByName(String name);

    public City findCityById(int id);
}
