package com.yhui.sys.controller;

import com.yhui.sys.constant.SysConstant;
import com.yhui.sys.domain.Menu;
import com.yhui.sys.domain.MenuVo;
import com.yhui.sys.domain.TreeNode;
import com.yhui.sys.domain.User;
import com.yhui.sys.service.IMenuService;
import com.yhui.sys.utils.DataGridView;
import com.yhui.sys.utils.ResultObj;
import com.yhui.sys.utils.TreeNodeBuilder;
import com.yhui.sys.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private IMenuService menuService;
    //创建加载菜单栏的方法
    @RequestMapping("loadIndexLeftMenuJson")
    public List<TreeNode> loadIndexLeftMenuJson(MenuVo menuVo) {
        //得到当前⽤户登录的对象
        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        List<Menu> list = null;
        menuVo.setAvailable(SysConstant.AVAILABLE_TRUE);//只⽤于查询可⽤的
        if (user.getType() == SysConstant.USER_TYPE_SUPER) {
            list = menuService.queryAllMenuForList(menuVo);
        } else {
            //TODO ⽤户如果不是管理员,展示的菜单是不同的,添加权限的时候补充
            //list = menuService.queryMenuByUserIdForList(menuVo,user.getUserId();
        }
        List<TreeNode> nodes = new ArrayList<>();
            //把list⾥的数据⽅到nodes
        for (Menu menu : list) {
            Integer id = menu.getId();
            Integer pid = menu.getPid();
            String title = menu.getTitle();
            String icon = menu.getIcon();
            String href = menu.getHref();
            Boolean spread = menu.getSpread() == SysConstant.SPREAD_TRUE ? true : false;
            String target = menu.getTarget();
            nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
        }
        return TreeNodeBuilder.builder(nodes, 1);
    }
    //加载菜单左侧树状结构
    @RequestMapping("loadMenuManagerLeftTreeJson")
    public DataGridView loadMenuManagerLeftTreeJson(MenuVo menuVo){
        menuVo.setAvailable(SysConstant.AVAILABLE_TRUE);
        List<Menu> menus = menuService.queryAllMenuForList(menuVo);
        List<TreeNode> nodes = new ArrayList<>();
        //把list⾥的数据⽅到nodes
        for (Menu menu : menus) {
            Integer id = menu.getId();
            Integer pid = menu.getPid();
            String title = menu.getTitle();
            String icon = menu.getIcon();
            String href = menu.getHref();
            Boolean spread = menu.getSpread() == SysConstant.SPREAD_TRUE ? true : false;
            String target = menu.getTarget();
            nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
        }
        return new DataGridView(nodes);
    }

    //加载菜单列表
    @RequestMapping("loadAllMenu")
    public DataGridView loadAllMenu(MenuVo menuVo){
        return menuService.queryAllMenu(menuVo);
    }

    //添加菜单
    @RequestMapping("addMenu")
    public ResultObj addMenu(MenuVo menuVo){
        try {
            menuService.addMenu(menuVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            return ResultObj.ADD_ERROR;
        }
    }
    //编辑菜单
    @RequestMapping("updateMenu")
    public ResultObj updateMenu(MenuVo menuVo){
        try {
            menuService.updateMenu(menuVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            return ResultObj.UPDATE_ERROR;
        }
    }
    //根据id判断当前菜单有没有子菜单
    @RequestMapping("checkMenuHasChildren")
    public ResultObj checkMenuHasChildren(MenuVo menuVo){
        Integer count = menuService.queryMenuByPid(menuVo.getPid());
        if (count > 0){
            return ResultObj.STATUS_TRUE;
        }else {
            return ResultObj.STATUS_FALSE;
        }
    }
    //删除菜单的方法
    @RequestMapping("deleteMenu")
    public ResultObj deleteMenu(MenuVo menuVo){
        try {
            menuService.deleteMenu(menuVo);

            return ResultObj.STATUS_TRUE;
        } catch (Exception e) {
            return ResultObj.STATUS_FALSE;
        }

    }
}
