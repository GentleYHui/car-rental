package com.yhui.sys.mapper;

import com.yhui.sys.domain.User;
import com.yhui.sys.domain.UserVo;

public interface UserMapper {
    User login(UserVo userVo);
}
