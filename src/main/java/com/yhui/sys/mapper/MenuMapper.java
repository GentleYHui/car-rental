package com.yhui.sys.mapper;

import com.yhui.sys.domain.Menu;
import com.yhui.sys.domain.MenuVo;

import java.util.List;

public interface MenuMapper {
    List<Menu> queryAllMenu(MenuVo menuVo);

    void insertSelective(MenuVo menuVo);

    void updateByPrimaryKeySelective(MenuVo menuVo);

    Integer queryMenuByPid(Integer pid);

    void deleteMenuByPrimaryKey(MenuVo menuVo);
}
