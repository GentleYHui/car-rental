package com.yhui.sys.utils;

import com.yhui.sys.constant.SysConstant;
import lombok.Data;

/**
 * 统一返回的对象
 */
@Data
public class ResultObj {
    private Integer code;
    private String msg;

    public ResultObj(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
    public ResultObj(Integer code){
        this.code = code;
    }

    // 添加成功
    public static ResultObj ADD_SUCCESS = new ResultObj(SysConstant.CODE_SUCCESS,SysConstant.ADD_SUCCESS);

    //添加失败
    public static ResultObj ADD_ERROR = new ResultObj(SysConstant.CODE_ERROR,SysConstant.ADD_ERROR);

    // 修改成功
    public static ResultObj UPDATE_SUCCESS = new ResultObj(SysConstant.CODE_SUCCESS,SysConstant.UPDATE_SUCCESS);

    //修改失败
    public static ResultObj UPDATE_ERROR = new ResultObj(SysConstant.CODE_ERROR,SysConstant.UPDATE_ERROR);

    // 删除成功
    public static ResultObj DELETE_SUCCESS = new ResultObj(SysConstant.CODE_SUCCESS,SysConstant.DELETE_SUCCESS);

    //删除失败
    public static ResultObj DELETE_ERROR = new ResultObj(SysConstant.CODE_ERROR,SysConstant.DELETE_ERROR);    // 删除成功

    //重置成功
    public static ResultObj RESET_SUCCESS = new ResultObj(SysConstant.CODE_SUCCESS,SysConstant.RESET_SUCCESS);

    //重置失败
    public static ResultObj RESET_ERROR = new ResultObj(SysConstant.CODE_ERROR,SysConstant.RESET_ERROR);

    //分配成功
    public static ResultObj DISPATCH_SUCCESS = new ResultObj(SysConstant.CODE_SUCCESS,SysConstant.DISPATCH_SUCCESS);

    //分配失败
    public static ResultObj DISPATCH_ERROR = new ResultObj(SysConstant.CODE_ERROR,SysConstant.DISPATCH_ERROR);

    //只有状态码的成功对象
    public static ResultObj STATUS_TRUE = new ResultObj(SysConstant.CODE_SUCCESS);
    public static ResultObj STATUS_FALSE = new ResultObj(SysConstant.CODE_ERROR);
}
