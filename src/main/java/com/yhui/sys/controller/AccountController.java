package com.yhui.sys.controller;

import com.yhui.sys.service.IAccountService;
import com.yhui.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService service;

    @RequestMapping("transfer")
    @ResponseBody
    @Transactional
    public ResultObj accountTransfer(String inName, String outName, double money){
        int status = service.updateTransfer(inName, outName, money); //1成功0失败
        if(status > 0){
            return ResultObj.STATUS_TRUE;
        }else {
            return ResultObj.STATUS_FALSE;
        }
    }
}
