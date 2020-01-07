package com.harshit.jpahibernate.mybatis.mapper;

import com.harshit.jpahibernate.entity.City;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    @Select("SELECT * FROM city WHERE state=#{state}")
    City findByState(@Param("state") String state);
}