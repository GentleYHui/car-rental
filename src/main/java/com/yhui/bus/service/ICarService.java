package com.yhui.bus.service;

import com.yhui.bus.domain.Car;
import com.yhui.bus.vo.CarVo;
import com.yhui.sys.utils.DataGridView;

public interface ICarService {
    DataGridView queryAllCar(CarVo carVo);

    void addCar(CarVo carVo);

    void deleteCar(String carnumber);

    Car queryCarByCarNumber(String carnumber);

    void updateCar(CarVo carVo);

    void deleteBatchCar(String[] ids);
}
