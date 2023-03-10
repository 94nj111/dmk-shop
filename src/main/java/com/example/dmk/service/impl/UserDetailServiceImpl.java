package com.example.dmk.service.impl;

import com.example.dmk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

  private final UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final var user = userService.getByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException(username + " not found");
    }
    List<GrantedAuthority> roles = List.of(new SimpleGrantedAuthority(user.getUserRole().toString()));
    return new User(user.getUsername(), user.getPassword(), roles);
  }
}
