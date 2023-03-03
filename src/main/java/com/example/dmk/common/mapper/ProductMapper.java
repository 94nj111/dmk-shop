package com.example.dmk.common.mapper;

import com.example.dmk.model.dto.ProductDto;
import com.example.dmk.persistence.entity.Product;
import org.mapstruct.Mapper;

/**
 * This interface defines methods for mapping between the {@link Product},
 * and {@link ProductDto} classes.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {

  /**
   * Maps a {@link Product} object to a {@link ProductDto} object.
   *
   * @param product The {@link Product} object to be mapped.
   * @return The resulting {@link ProductDto} object.
   */
  ProductDto productToProductDto(Product product);

  /**
   * Maps a {@link ProductDto} object to a {@link Product} object.
   *
   * @param productDto The {@link ProductDto} object to be mapped.
   * @return The resulting {@link Product} object.
   */
  Product productDtoToProduct(ProductDto productDto);
}
