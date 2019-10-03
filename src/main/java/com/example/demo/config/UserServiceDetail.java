package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class UserServiceDetail implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 根据用户名获取登录用户信息
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("role");
        collection.add(authority);
        return new User(username, passwordEncoder.encode("123456"), collection);
    }
}