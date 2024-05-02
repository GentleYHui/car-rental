package com.yhui.sys.service.impl;

import com.yhui.sys.mapper.AccountMapper;
import com.yhui.sys.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AccountMapper mapper;
    @Override
    public int updateTransfer(String inName, String outName, double money) {
        try {
            mapper.transferIn(inName, money);
            mapper.transferOut(outName, money);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }

    }
}
