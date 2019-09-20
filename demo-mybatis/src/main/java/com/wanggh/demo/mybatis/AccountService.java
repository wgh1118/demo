package com.wanggh.demo.mybatis;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wanggh
 */
@Service
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    @DS("slave")
    public Account get(Long id) {
        return accountMapper.selectById(id);
    }

    @DS("master")
    public Account insert(Account account) {
        accountMapper.insert(account);
        return account;
    }
}
