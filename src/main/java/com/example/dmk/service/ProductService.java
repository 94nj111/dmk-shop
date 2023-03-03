package com.example.dmk.service;

import com.example.dmk.persistence.entity.Product;
import lombok.NonNull;

import java.util.List;

public interface ProductService {

  Product createProduct(@NonNull final Product product);

  Product updateProduct(@NonNull final Product product);
  List<Product> getAll();

  List<Product> getAllByType(@NonNull final String type);

  Product getById(@NonNull final Long id);

  void deleteProductById(@NonNull final Long id);
}
