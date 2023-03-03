package com.example.dmk.service.impl;

import com.example.dmk.persistence.entity.Cart;
import com.example.dmk.persistence.entity.SalesProduct;
import com.example.dmk.service.CartActivatorService;
import com.example.dmk.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class CartActivatorServiceImpl implements CartActivatorService {

  private final ProductService productService;

  public CartActivatorServiceImpl(ProductService productService) {
    this.productService = productService;
  }

  @Override
  public void activateCart(final Cart cart) {
    final var products = cart.getSalesProductList();
    for (SalesProduct salesProduct : products) {
      final var product = productService.getById(salesProduct.getId());
      final var quantity = product.getQuantity() - salesProduct.getQuantity();
      product.setQuantity(quantity);
      productService.updateProduct(product);
    }
  }
}
