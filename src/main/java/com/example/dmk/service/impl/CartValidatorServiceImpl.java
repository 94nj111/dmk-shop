package com.example.dmk.service.impl;

import com.example.dmk.persistence.entity.Cart;
import com.example.dmk.persistence.entity.SalesProduct;
import com.example.dmk.service.CartValidatorService;
import com.example.dmk.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartValidatorServiceImpl implements CartValidatorService {

  private final ProductService productService;

  public CartValidatorServiceImpl(ProductService productService) {
    this.productService = productService;
  }

  @Override
  public List<SalesProduct> isValid(Cart cart) {
    final var products = cart.getSalesProductList();
    final var notValid = new ArrayList<SalesProduct>();
    for (SalesProduct salesProduct : products) {
      final var product = productService.getById(salesProduct.getId());
      if (product.getQuantity() < salesProduct.getQuantity()) {
        notValid.add(SalesProduct.builder().productId(salesProduct.getId()).quantity(product.getQuantity()).build());
      }
    }
    return notValid;
  }
}
