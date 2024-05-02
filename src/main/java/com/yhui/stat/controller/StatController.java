package com.yhui.stat.controller;


import com.yhui.bus.domain.Customer;
import com.yhui.bus.domain.Rent;
import com.yhui.bus.service.ICustomerService;
import com.yhui.bus.service.IRentService;
import com.yhui.sys.utils.ExportRentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RequestMapping("stat")
@Controller
public class StatController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IRentService rentService;
    //导出出租单
    @RequestMapping("exportRent")
    public ResponseEntity<Object> exportRent(String rentid) throws UnsupportedEncodingException {
         //根据出租id查询出租单
        Rent rent = rentService.queryRentByRentId(rentid);
        Customer customer = customerService.queryCustomerByIdentity(rent.getIdentity());
        String fileName = customer.getCustname() + "-的出租单.xls";
        String sheetName = customer.getCustname() + "出租单";
        //通过工具类进行到处操作
        ByteArrayOutputStream bos = ExportRentUtils.exportRent(rent, customer, sheetName);
        //处理文件名称乱码
        fileName = URLEncoder.encode(fileName,"UTF-8");
        //由于要进行下载，所以要设置头信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //设置下载文件名称
        headers.setContentDispositionFormData("attachment", fileName);
        //将数据组装返回
        return new ResponseEntity<Object>(bos.toByteArray(),headers, HttpStatus.CREATED);
    }
}
