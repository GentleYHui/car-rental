package com.yhui.sys.service;

import com.yhui.sys.domain.Menu;
import com.yhui.sys.domain.MenuVo;
import com.yhui.sys.utils.DataGridView;

import java.util.List;

public interface IMenuService {
    List<Menu> queryAllMenuForList(MenuVo menuVo);

    DataGridView queryAllMenu(MenuVo menuVo);

    void addMenu(MenuVo menuVo);

    void updateMenu(MenuVo menuVo);

    Integer queryMenuByPid(Integer pid);

    void deleteMenu(MenuVo menuVo);
}
