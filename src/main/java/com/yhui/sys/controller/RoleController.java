package com.yhui.sys.controller;

import com.yhui.sys.domain.RoleVo;
import com.yhui.sys.service.IRoleService;
import com.yhui.sys.utils.DataGridView;
import com.yhui.sys.utils.ResultObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class RoleController {
    //注入Service
    private IRoleService roleService;

    //加载角色列表
    @RequestMapping("loadAllRole")
    public DataGridView loadAllRole(RoleVo roleVo){
        return roleService.queryAllRole(roleVo);
    }

    //添加角色
    @RequestMapping("addRole")
    public ResultObj addRole(RoleVo roleVo){
        try {
            roleService.addRole(roleVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            return ResultObj.ADD_ERROR;
        }
    }

    //修改角色
    @RequestMapping("updateRole")
    public ResultObj updateRole(RoleVo roleVo){
        try {
            roleService.updateRole(roleVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            return ResultObj.UPDATE_SUCCESS;
        }
    }
    //删除角色
    @RequestMapping("deleteRole")
    public ResultObj deleteRole(RoleVo roleVo){
        try {
            roleService.deleteRole(roleVo.getRoleid());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            return ResultObj.DELETE_ERROR;
        }
    }

    //批量删除角色
    @RequestMapping("deleteBatchRole")
    public ResultObj deleteBatchRole(RoleVo roleVo){
        try {
            roleService.deleteBatchRole(roleVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            return ResultObj.DELETE_ERROR;
        }
    }
}
