package com.whj.springboot.mapper;

import com.whj.springboot.domain.City;
import org.apache.ibatis.annotations.Param;

/**
 * Created by wuhaijun on 2017/7/22.
 */
public interface CityMapper {

    public City findByName(@Param("cityName") String cityName);

    public City findById(@Param("id") int id);
}
