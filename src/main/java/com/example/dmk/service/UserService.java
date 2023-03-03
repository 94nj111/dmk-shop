package com.example.dmk.service;

import com.example.dmk.persistence.entity.DmkUser;

public interface UserService {

  DmkUser createUser(DmkUser dmkUser);

  DmkUser getByUsername(String username);

  void deleteUser(Long id);

  boolean isExist(DmkUser dmkUser);
}
