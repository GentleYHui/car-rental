package com.yhui.bus.mapper;

import com.yhui.bus.domain.Car;
import com.yhui.bus.vo.CarVo;

import java.util.List;

public interface CarMapper {
    List<Car> queryAllCar(CarVo carVo);

    void insertSelective(CarVo carVo);

    Car selectByPrimaryKey(String carnumber);

    void deleteByPrimaryKey(String carnumber);

    void updateByPrimaryKeySelective(CarVo carVo);
}
