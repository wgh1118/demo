package com.wanggh.demo.mybatis;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wanggh
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping(value = "/{id}")
    public Account get(@PathVariable("id") Long id) {
        return accountService.get(id);
    }

    @PostMapping
    public Account insert(Account account) {
        accountService.insert(account);
        return account;
    }
}
