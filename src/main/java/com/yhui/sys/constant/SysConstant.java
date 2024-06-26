package com.yhui.sys.constant;

/**
常量接口
 */
public interface SysConstant {

    //用户登录相关常量
    String USER_LOGIN_ERROR_MSG = "用户名或密码错误";
    String USER_LOGIN_CODE_ERROR_MSG = "验证码错误";

    //可用状态常量
    Integer AVAILABLE_TRUE = 1;
    Integer AVAILABLE_FALSE = 0;

    //用户类型
    Integer USER_TYPE_SUPER = 1; //超级管理员
    Integer USER_TYPE_NORMAL = 2; //普通用户

    //是否展开菜单
    Integer SPREAD_TRUE = 1;
    Integer SPREAD_FALSE = 0;

    //操作状态
    String ADD_SUCCESS = "添加成功";
    String ADD_ERROR = "添加失败";
    String UPDATE_SUCCESS = "修改成功";
    String UPDATE_ERROR = "修改失败";
    String DELETE_SUCCESS = "删除成功";
    String DELETE_ERROR = "删除失败";
    String RESET_SUCCESS = "重置成功";
    String RESET_ERROR = "重置失败";
    String DISPATCH_SUCCESS = "分配成功";
    String DISPATCH_ERROR = "分配失败";
    Integer CODE_SUCCESS = 0; //操作成功
    Integer CODE_ERROR = -1; //操作失败

    //公用常量
    Integer CODE_ZERO = 0;
    Integer CODE_ONE = 1;
    Integer CODE_TWO = 2;
    Integer CODE_THREE = 3;

    //用户默认密码
    String USER_DEFAULT_PASSWORD = "123456";

    //临时文件标记
    String FILE_UPLOAD_TEMP = "temp";

    //设置默认图片地址
    String DEFAULT_CAR_IMG = "images/defaultcarimg.jpg";

    //单号的前缀
    String CAR_ORDER_CZ = "CZ"; //出租车辆订单的前缀
    String CAR_ORDER_JC = "JC"; //检查车辆订单前缀

    //归还状态
    Integer RENT_BACK_FALSE = 0; //未归还
    Integer RENT_BACK_TRUE = 1; //已归还

    //出租状态
    Integer RENT_CAR_TRUE = 1; //已出租
    Integer RENT_CAR_FALSE = 0; //未出租


}
