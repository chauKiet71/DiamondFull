package com.example.diamond.dao;

import com.example.diamond.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account, String> {

    Account findByEmail(String email);
}
