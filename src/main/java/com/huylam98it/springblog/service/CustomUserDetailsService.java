package com.huylam98it.springblog.service;

import com.huylam98it.springblog.dao.AccountDao;
import com.huylam98it.springblog.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    AccountDao accountDao;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Account account=accountDao.findAccountByUsername(s);
        if(account==null)
            throw new UsernameNotFoundException("khong tim thay user");
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        User user=new User(s,account.getPassword(),grantedAuthorities);
        return user;
    }
}
