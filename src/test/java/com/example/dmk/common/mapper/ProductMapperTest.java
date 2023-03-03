package com.example.dmk.common.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.dmk.model.dto.ProductDto;
import com.example.dmk.persistence.entity.Product;
import com.example.dmk.persistence.entity.Type;
import org.junit.jupiter.api.Test;

public class ProductMapperTest {

  private final ProductMapperImpl productMapper = new ProductMapperImpl();

  private static final Product PRODUCT = Product.builder()
      .id(1L)
      .name("Кросівки Adidas Easy Boost")
      .size("43")
      .price(239.99)
      .type(Type.ВЗУТТЯ)
      .quantity(20)
      .build();
  private static final ProductDto PRODUCT_DTO = ProductDto.builder()
      .id(1L)
      .name("Кросівки Adidas Easy Boost")
      .size("43")
      .price(239.99)
      .type(Type.ВЗУТТЯ)
      .build();


  @Test
  void testProductToProductDto() {
    final var productDto = productMapper.productToProductDto(PRODUCT);

    assertEquals(productDto.getId(), PRODUCT.getId());
    assertEquals(productDto.getPrice(), PRODUCT.getPrice());
    assertEquals(productDto.getType(), PRODUCT.getType());
    assertEquals(productDto.getSize(), PRODUCT.getSize());
    assertEquals(productDto.getName(), PRODUCT.getName());
  }

  @Test
  void testProductDtoToProduct() {
    final var product = productMapper.productDtoToProduct(PRODUCT_DTO);

    assertEquals(product.getId(), PRODUCT_DTO.getId());
    assertEquals(product.getPrice(), PRODUCT_DTO.getPrice());
    assertEquals(product.getType(), PRODUCT_DTO.getType());
    assertEquals(product.getSize(), PRODUCT_DTO.getSize());
    assertEquals(product.getName(), PRODUCT_DTO.getName());
  }
}
