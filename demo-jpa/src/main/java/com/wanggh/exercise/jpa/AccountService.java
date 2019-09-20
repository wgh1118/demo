package com.wanggh.exercise.jpa;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AccountService {
    @Resource
    private AccountRepository accountRepository;

    public Account get(Long id) {
        Optional<Account> optional = accountRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            Account account = new Account();
            account.setId(-1L);
            return account;
        }
    }

    @Ds(name = DsType.SLAVE)
    public Account getById(Long id) {
        Optional<Account> optional = accountRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            Account account = new Account();
            account.setId(-1L);
            return account;
        }
    }
}