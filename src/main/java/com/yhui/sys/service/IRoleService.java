package com.yhui.sys.service;

import com.yhui.sys.domain.RoleVo;
import com.yhui.sys.utils.DataGridView;

public interface IRoleService {
    DataGridView queryAllRole(RoleVo roleVo);

    void addRole(RoleVo roleVo);

    void updateRole(RoleVo roleVo);

    void deleteRole(Integer roleid);

    void deleteBatchRole(Integer[] ids);
}
