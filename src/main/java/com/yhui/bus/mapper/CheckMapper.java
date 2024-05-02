package com.yhui.bus.mapper;

import com.yhui.bus.domain.Check;
import com.yhui.bus.vo.CheckVo;

import java.util.List;

public interface CheckMapper {
    //添加检查单
    void insertSelective(CheckVo checkVo);

    List<Check> queryAllCheck(CheckVo checkVo);

    void updateCheckByPrimaryKey(CheckVo checkVo);

    void deleteByPrimaryKey(String checkid);
}
