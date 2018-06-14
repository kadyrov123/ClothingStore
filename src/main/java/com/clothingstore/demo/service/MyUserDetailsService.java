package com.clothingstore.demo.service;

import com.clothingstore.demo.Dao.Dao;
import com.clothingstore.demo.Model.MyUserPrincipl;
import com.clothingstore.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private Dao dao;

    @Override
    public UserDetails loadUserByUsername(String username){
        User user = dao.getUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipl(user);
    }
}
