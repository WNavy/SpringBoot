package com.whj.springboot.dao.impl;

import com.whj.springboot.dao.CityDao;
import com.whj.springboot.domain.City;
import com.whj.springboot.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wuhaijun on 2017/7/22.
 */
@Repository("cityDao")
public class CityDaoImpl implements CityDao {

    @Autowired
    private CityMapper mapper;

    @Override
    public City findCityByName(String name) {
        return mapper.findByName(name);
    }

    @Override
    public City findCityById(int id) {
        return mapper.findById(id);
    }
}
