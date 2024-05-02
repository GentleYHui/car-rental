package com.yhui.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yhui.sys.domain.Role;
import com.yhui.sys.domain.RoleVo;
import com.yhui.sys.mapper.RoleMapper;
import com.yhui.sys.service.IRoleService;
import com.yhui.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public DataGridView queryAllRole(RoleVo roleVo) {
        Page<Object> page =
                PageHelper.startPage(roleVo.getPage(),roleVo.getLimit());
        List<Role> data = this.roleMapper.queryAllRole(roleVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void addRole(RoleVo roleVo) {
        roleMapper.insertSelective(roleVo);
    }

    @Override
    public void deleteRole(Integer roleid) {
        roleMapper.deleteByPrimaryKey(roleid);
    }

    @Override
    public void updateRole(RoleVo roleVo) {
        roleMapper.updateByPrimarySelective(roleVo);
    }

    @Override
    public void deleteBatchRole(Integer[] ids) {
        for (Integer id : ids) {
            roleMapper.deleteByPrimaryKey(id);
        }
    }
}
