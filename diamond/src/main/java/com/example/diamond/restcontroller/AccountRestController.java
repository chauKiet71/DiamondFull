package com.example.diamond.restcontroller;

import com.example.diamond.dao.AccountDao;
import com.example.diamond.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/account")
public class AccountRestController {

    @Autowired
    AccountDao dao;

    @GetMapping()
    public List<Account> getAllAccounts() {
        return dao.findAll();
    }

    @PostMapping
    public Account create(@RequestBody Account account) {
        return dao.save(account);
    }

    @PutMapping("{id}")
    public Account update(@PathVariable("id")String id, @RequestBody Account account) {
        return dao.save(account);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id) {
        dao.deleteById(id);
    }

    @GetMapping("{id}")
    public Account getById(@PathVariable("id")String username){
        return dao.findById(username).get();
    }
}
