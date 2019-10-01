package com.example.demo.config;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  private UserDao userDao;

  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    User userByUserName = userDao.getUserByUserName(name);
    if (userByUserName == null) {
      throw new UsernameNotFoundException("用户名不存在");
    }
    log.info("#######################");
    return new org.springframework.security.core.userdetails.User(userByUserName.getUserName(),
        userByUserName.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("role"));
  }
}
