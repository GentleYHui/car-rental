package com.yhui.sys.service;

import com.yhui.sys.domain.User;
import com.yhui.sys.domain.UserVo;

public interface IUserService {
    User login(UserVo userVo);
}
