package com.example.dmk.api.rest.controller;

import com.example.dmk.common.ApplicationConstants;
import com.example.dmk.common.mapper.ProductMapper;
import com.example.dmk.model.dto.ProductDto;
import com.example.dmk.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {
  private final ProductMapper productMapper;
  private final ProductService productService;

  @PermitAll
  @GetMapping("/categories")
  public ResponseEntity<?> getAllTypes() {
    return ResponseEntity.ok().body(ApplicationConstants.Types.PRODUCTS);
  }

  @PermitAll
  @GetMapping("/category/{type}")
  public ResponseEntity<List<ProductDto>> getByType(@PathVariable ("type") final String type) {
    final var products = productService.getAllByType(type);
    if (products.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    final var productsResponse = products.stream().map(productMapper::productToProductDto).toList();
    return ResponseEntity.ok().body(productsResponse);
  }

  @PermitAll
  @GetMapping("/{id}")
  public ResponseEntity<ProductDto> getById(@PathVariable ("id") final Long id) {
    final var product = productService.getById(id);
    if (product == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    final var productResponse = productMapper.productToProductDto(product);
    return ResponseEntity.ok().body(productResponse);
  }

  @PermitAll
  @GetMapping
  public ResponseEntity<List<ProductDto>> getAll() {
    final var products = productService.getAll();
    if (products.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    final var productsResponse = products.stream().map(productMapper::productToProductDto).toList();
    return ResponseEntity.ok().body(productsResponse);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PostMapping
  public ResponseEntity<ProductDto> createProduct(@RequestBody final ProductDto productDto) {
    final var productToSave = productMapper.productDtoToProduct(productDto);
    final var product = productService.createProduct(productToSave);
    final var productResponse = productMapper.productToProductDto(product);
    return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PatchMapping
  public ResponseEntity<ProductDto> updateProduct(@RequestBody final ProductDto productDto) {
    final var productToUpdate = productMapper.productDtoToProduct(productDto);
    final var updateProduct = productService.updateProduct(productToUpdate);
    final var productResponse = productMapper.productToProductDto(updateProduct);
    return ResponseEntity.ok().body(productResponse);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @DeleteMapping
  public ResponseEntity<ProductDto> deleteProduct(@RequestBody final List<ProductDto> toDelete) {
    toDelete.forEach(a -> productService.deleteProductById(a.getId()));
    return ResponseEntity.status(204).build();
  }
}
