package com.yhui.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bus")
public class BusController {
    //跳转到客户管理页面
    @RequestMapping("toCustomerManager")
    public String toCustomerManager(){
        return "business/customer/customerManager";
    }
    //跳转到车辆管理页面
    @RequestMapping("toCarManager")
    public String toCarManager(){
        return "business/car/carManager";
    }
    //跳转到车辆管理页面
    @RequestMapping("toRentCarManager")
    public String toRentCarManager(){
        return "business/rent/rentCarManager";
    }
    //跳转到出租单管理页
    @RequestMapping("toRentManager")
    public String toRentManager(){
        return "business/rent/rentManager";
    }
    //跳转到汽车入库管理页
    @RequestMapping("toCheckCarManager")
    public String checkCarManager(){
        return "business/check/checkCarManager";
    }
    //跳转到检查单管理页
    @RequestMapping("toCheckManager")
    public String checkManager(){
        return "business/check/checkManager";
    }
}
