package com.example.dmk.model.dto;

import com.example.dmk.persistence.entity.Type;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {

  Long id;

  String name;

  String description;

  String picture;

  Double price;

  String size;

  Type type;

  Integer quantity;
}
