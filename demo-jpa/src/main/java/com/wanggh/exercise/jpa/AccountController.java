package com.wanggh.exercise.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanggh
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public Account getById(@PathVariable Long id) {
        return accountService.getById(id);
    }

    @GetMapping("/get/{id}")
    public Account get(@PathVariable Long id) {
        return accountService.get(id);
    }
}
