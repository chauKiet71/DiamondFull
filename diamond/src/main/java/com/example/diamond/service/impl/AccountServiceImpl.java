package com.example.diamond.service.impl;

import com.example.diamond.dao.AccountDao;
import com.example.diamond.entity.Account;
import com.example.diamond.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public Account resgisterAccount(Account account) {
        return accountDao.save(account);
    }
}
