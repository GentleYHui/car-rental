package com.yhui.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yhui.bus.domain.Car;
import com.yhui.bus.mapper.CarMapper;
import com.yhui.bus.service.ICarService;
import com.yhui.bus.vo.CarVo;
import com.yhui.sys.constant.SysConstant;
import com.yhui.sys.utils.AppFileUtils;
import com.yhui.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements ICarService {
    @Override
    public void deleteBatchCar(String[] ids) {
        for (String carnumber : ids) {
            this.deleteCar(carnumber);
        }
    }

    @Autowired
    private CarMapper carmapper;
    @Override
    public DataGridView queryAllCar(CarVo carVo) {
        Page<Car> page = PageHelper.startPage(carVo.getPage(), carVo.getLimit());
        List<Car> data = carmapper.queryAllCar(carVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void addCar(CarVo carVo) {
        this.carmapper.insertSelective(carVo);
    }

    @Override
    public Car queryCarByCarNumber(String carnumber) {
        return carmapper.selectByPrimaryKey(carnumber);

    }

    @Override
    public void updateCar(CarVo carVo) {
        carmapper.updateByPrimaryKeySelective(carVo);
    }

    @Override
    public void deleteCar(String carnumber) {
        //先删除图片
        Car car = carmapper.selectByPrimaryKey(carnumber);
        if (!car.getCarimg().equals(SysConstant.DEFAULT_CAR_IMG)){
            AppFileUtils.deleteFileUsePath(car.getCarimg());
        }
        //删除数据库数据
        carmapper.deleteByPrimaryKey(carnumber);
    }
}
