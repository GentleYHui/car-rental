package com.yhui.bus.mapper;

import com.yhui.bus.domain.Rent;
import com.yhui.bus.vo.RentVo;

import java.util.List;

public interface RentMapper {
    void insertSelective(RentVo rentVo);

    List<Rent> queryAllRent(RentVo rentVo);

    void updateByPrimaryKeySelective(RentVo rentVo);

    void deleteByPrimaryKey(String rentid);

    Rent queryRentById(String rentid);

    RentVo selectByPrimaryKey(String rentid);
}
