package com.yhui.sys.controller;

import com.yhui.sys.constant.SysConstant;
import com.yhui.sys.domain.MenuVo;
import com.yhui.sys.utils.DataGridView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("sys")
public class SysController {

    //跳转到菜单管理
    @RequestMapping("toMenuManager")
    public String toMenuManager(){
        return "system/menu/menuManager";
    }

    //跳转到dTree页面
    @RequestMapping("dTreeDemo")
    public String todTreeDemo(){
        return "system/menu/dTreeDemo";
    }
    //跳转到dTree页面
    @RequestMapping("toMenuLeft")
    public String toMenuLeft(){
        return "system/menu/MenuLeft";
    }
    //跳转到dTree页面
    @RequestMapping("toMenuRight")
    public String toMenuRight(){
        return "system/menu/MenuRight";
    }

}
