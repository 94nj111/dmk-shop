package com.example.dmk.service.impl;

import com.example.dmk.persistence.entity.DmkUser;
import com.example.dmk.persistence.entity.UserRole;
import com.example.dmk.persistence.reposirory.UserRepository;
import com.example.dmk.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Bean
  private PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public DmkUser createUser(final DmkUser dmkUser) {
    final var passHash = passwordEncoder().encode(dmkUser.getPassword());
    dmkUser.setPassword(passHash);
    dmkUser.setUserRole(UserRole.USER);
    return userRepository.save(dmkUser);
  }

  @Override
  public DmkUser getByUsername(final String email) {
    return userRepository.findByUsername(email);
  }

  @Override
  public void deleteUser(final Long id) {
    userRepository.deleteById(id);
  }

  @Override
  public boolean isExist(DmkUser dmkUser) {
    return userRepository.existsByUsername(dmkUser.getUsername());
  }
}
