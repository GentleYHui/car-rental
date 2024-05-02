package com.yhui.bus.service;

import com.yhui.bus.vo.CheckVo;
import com.yhui.sys.utils.DataGridView;

import java.util.Map;

public interface ICheckService {
    Map<String, Object> initCheckFromData(String rentid);

    void addCheck(CheckVo checkVo);

    DataGridView queryAllCheck(CheckVo checkVo);

    void updateCheck(CheckVo checkVo);

    void deleteCheck(String checkid);

    void deleteBatchCheck(String[] ids);
}
