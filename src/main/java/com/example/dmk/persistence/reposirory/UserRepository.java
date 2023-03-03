package com.example.dmk.persistence.reposirory;

import com.example.dmk.persistence.entity.DmkUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<DmkUser, Long> {

  DmkUser findByPhoneNumber(String phoneNumber);

  DmkUser findByUsername(String username);

  Boolean existsByPhoneNumber(String phoneNumber);

  Boolean existsByUsername(String username);
}
