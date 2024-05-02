package com.yhui.sys.service.impl;

import com.yhui.sys.domain.User;
import com.yhui.sys.domain.UserVo;
import com.yhui.sys.mapper.UserMapper;
import com.yhui.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    //用户登录核心方法
    @Override
    public User login(UserVo userVo) {
        //先对用户输入密码进行加密
        String pwd = DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes());
        userVo.setPwd(pwd);
        //调用UserMapper中的查询方法
        return userMapper.login(userVo);
    }


}
