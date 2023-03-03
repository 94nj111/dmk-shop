package com.example.dmk.api.rest.controller;

import com.example.dmk.common.ApplicationConstants;
import com.example.dmk.common.mapper.CartMapper;
import com.example.dmk.model.dto.CartDto;
import com.example.dmk.service.CartActivatorService;
import com.example.dmk.service.CartService;
import com.example.dmk.service.CartValidatorService;
import com.example.dmk.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

  private final CartService cartService;
  private final CartMapper cartMapper;
  private final UserService userService;
  private final CartActivatorService cartActivatorService;
  private final CartValidatorService cartValidatorService;

  public CartController(CartService cartService, CartMapper cartMapper, UserService userService, CartActivatorService cartActivatorService, CartValidatorService cartValidatorService) {
    this.cartService = cartService;
    this.cartMapper = cartMapper;
    this.userService = userService;
    this.cartActivatorService = cartActivatorService;
    this.cartValidatorService = cartValidatorService;
  }

  @PostMapping
  public ResponseEntity<CartDto> createCart(@RequestBody final CartDto cartDto) {
    final var cartToSave = cartMapper.cartDtoToCart(cartDto);
    final var valid = cartValidatorService.isValid(cartToSave);
    if (!valid.isEmpty()) {
      cartToSave.setSalesProductList(valid);
      final var badRequestBody = cartMapper.cartToCartDto(cartToSave);
      return ResponseEntity.badRequest().body(badRequestBody);
    }
    cartActivatorService.activateCart(cartToSave);
    final var createdCart = cartService.createCart(cartToSave);
    final var cartResponse = cartMapper.cartToCartDto(createdCart);
    return ResponseEntity.status(HttpStatus.CREATED).body(cartResponse);
  }

  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
  @GetMapping
  public ResponseEntity<List<CartDto>> getUserCarts(@AuthenticationPrincipal final User user) {
    final var dmkUser = userService.getByUsername(user.getUsername());
    final var userCarts = cartService.getCartsByUser(dmkUser);
    if (userCarts.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    final var cartsResponse = userCarts.stream().map(cartMapper::cartToCartDto).toList();
    return ResponseEntity.ok().body(cartsResponse);
  }

  @GetMapping("/delivery-type")
  public ResponseEntity<?> getAllTypes() {
    return ResponseEntity.ok().body(ApplicationConstants.Types.DELIVERY);
  }
}
