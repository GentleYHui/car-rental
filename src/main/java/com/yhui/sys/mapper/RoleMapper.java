package com.yhui.sys.mapper;

import com.yhui.sys.domain.Role;
import com.yhui.sys.domain.RoleVo;

import java.util.List;

public interface RoleMapper {
    public List<Role> queryAllRole(RoleVo roleVo);

    void insertSelective(RoleVo roleVo);

    void updateByPrimarySelective(RoleVo roleVo);

    void deleteByPrimaryKey(Integer roleid);
}
