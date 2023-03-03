package com.example.dmk.service;

import com.example.dmk.persistence.entity.Cart;
import com.example.dmk.persistence.entity.DmkUser;

import java.util.List;

public interface CartService {

  Cart createCart(Cart cart);

  List<Cart> getCartsByUser(DmkUser dmkUser);
}
