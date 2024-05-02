package com.yhui.bus.service;

import com.yhui.bus.domain.Rent;
import com.yhui.bus.vo.RentVo;
import com.yhui.sys.utils.DataGridView;

public interface IRentService {
    void addRent(RentVo rentVo);

    DataGridView queryAllRent(RentVo rentVo);

    void updateRent(RentVo rentVo);

    void deleteRent(RentVo rentVo);

    Rent queryRentByRentId(String rentid);
}
