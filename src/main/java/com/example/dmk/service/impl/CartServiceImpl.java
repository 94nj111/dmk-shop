package com.example.dmk.service.impl;

import com.example.dmk.persistence.entity.Cart;
import com.example.dmk.persistence.entity.DmkUser;
import com.example.dmk.persistence.reposirory.CartRepository;
import com.example.dmk.service.CartService;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

  private final CartRepository cartRepository;

  public CartServiceImpl(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  @Override
  public Cart createCart(final Cart cart) {
    cart.setCreated(new Date());
    return cartRepository.save(cart);
  }

  @Override
  public List<Cart> getCartsByUser(final DmkUser dmkUser) {
    return cartRepository.findAllByPhoneNumber(dmkUser.getPhoneNumber());
  }
}
