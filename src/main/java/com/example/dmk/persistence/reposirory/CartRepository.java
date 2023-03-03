package com.example.dmk.persistence.reposirory;

import com.example.dmk.persistence.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

  List<Cart> findAllByPhoneNumber(String phoneNumber);
}
