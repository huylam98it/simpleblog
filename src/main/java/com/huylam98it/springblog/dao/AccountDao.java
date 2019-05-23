package com.huylam98it.springblog.dao;

import com.huylam98it.springblog.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account,String> {

    Account findAccountByUsername(String username);
}
