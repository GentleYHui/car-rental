package com.yhui.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yhui.bus.domain.Car;
import com.yhui.bus.domain.Rent;
import com.yhui.bus.mapper.CarMapper;
import com.yhui.bus.mapper.RentMapper;
import com.yhui.bus.service.IRentService;
import com.yhui.bus.vo.CarVo;
import com.yhui.bus.vo.RentVo;
import com.yhui.sys.constant.SysConstant;
import com.yhui.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements IRentService {
    @Autowired
    private RentMapper rentMapper;

    @Autowired
    private CarMapper carMapper;
    @Override
    public void addRent(RentVo rentVo) {
        this.rentMapper.insertSelective(rentVo);
        //更改车辆出租信息
        CarVo carVo = new CarVo();
        carVo.setCarnumber(rentVo.getCarnumber());
        //设置车辆状态为已出租
        carVo.setIsrenting(SysConstant.RENT_CAR_TRUE);
        carMapper.updateByPrimaryKeySelective(carVo);
    }

    //分页查询出租单
    @Override
    public DataGridView queryAllRent(RentVo rentVo) {
        Page<Rent> page = PageHelper.startPage(rentVo.getPage(),rentVo.getLimit());
        //查询全部
        List<Rent> data = rentMapper.queryAllRent(rentVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void updateRent(RentVo rentVo) {
        rentMapper.updateByPrimaryKeySelective(rentVo);
    }

    @Override
    public void deleteRent(RentVo rentVo) {
        CarVo carVo = new CarVo();
        carVo.setCarnumber(rentVo.getCarnumber());
        //删除订单要将车辆改为未出租状态
        carVo.setIsrenting(SysConstant.RENT_CAR_FALSE);
        //删除出租单
        rentMapper.deleteByPrimaryKey(rentVo.getRentid());
        //更新车辆状态
        carMapper.updateByPrimaryKeySelective(carVo);

    }

    @Override
    public Rent queryRentByRentId(String rentid) {
        return rentMapper.queryRentById(rentid);
    }
}
