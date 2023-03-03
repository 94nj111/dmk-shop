package com.example.dmk.service.impl;

import com.example.dmk.persistence.entity.Product;
import com.example.dmk.persistence.reposirory.ProductRepository;
import com.example.dmk.service.ProductService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product createProduct(@NonNull final Product product) {
    return productRepository.save(product);
  }

  @Override
  public Product updateProduct(@NonNull final Product product) {
    return productRepository.save(product);
  }

  @Override
  public List<Product> getAll() {
    return productRepository.findAll();
  }

  @Override
  public List<Product> getAllByType(@NonNull final String type) {
    return productRepository.getAllByType(type);
  }

  @Override
  public Product getById(@NonNull final Long id) {
    return productRepository.getById(id);
  }

  @Override
  public void deleteProductById(@NonNull final Long id) {
    productRepository.deleteById(id);
  }
}
