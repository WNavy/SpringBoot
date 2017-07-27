package com.whj.springboot.controller;

import com.whj.springboot.domain.City;
import com.whj.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuhaijun on 2017/7/22.
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value="/api/city",method = RequestMethod.GET)
    public City fundCityByName(@RequestParam(value = "cityName",required = true) String cityName){
        return cityService.findCityByName(cityName);
    }

    @RequestMapping(value="/api/cityById",method = RequestMethod.GET)
    public City findCityById(@RequestParam(value = "id" , required = true)int id){
        return cityService.findCityById(id);
    }
}
