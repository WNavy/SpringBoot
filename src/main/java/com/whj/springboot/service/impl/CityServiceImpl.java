package com.whj.springboot.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whj.springboot.dao.CityDao;
import com.whj.springboot.domain.City;
import com.whj.springboot.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by wuhaijun on 2017/7/22.
 */
@Service("cityService")
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;
    @Autowired
    private RedisTemplate redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

    @Override
    public City findCityByName(String name) {
        return cityDao.findCityByName(name);
    }

    @Override
    public City findCityById(int id) {
        String key = "city_" + id;
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        boolean haskey = redisTemplate.hasKey(key);
        if(haskey){
            JSON cityJson = JSONObject.parseObject(operations.get(key));
            City city = JSONObject.toJavaObject(cityJson,City.class);
            return city;
        }
        City city = cityDao.findCityById(id);
        operations.set(key,"test");
        return city;
    }
}
