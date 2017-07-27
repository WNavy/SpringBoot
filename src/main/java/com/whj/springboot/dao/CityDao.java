package com.whj.springboot.dao;

import com.whj.springboot.domain.City;

/**
 * Created by wuhaijun on 2017/7/22.
 */
public interface CityDao {

    public City findCityByName(String name);

    public City findCityById(int id);
}
