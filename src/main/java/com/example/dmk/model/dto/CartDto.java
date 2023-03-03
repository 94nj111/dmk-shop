package com.example.dmk.model.dto;

import com.example.dmk.persistence.entity.DeliveryType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartDto {

  String name;

  String phoneNumber;

  String email;

  DeliveryType deliveryType;

  String deliveryAddress;

  List<SalesProductDto> salesProductList;

  Date created;

  Double totalCost;
}
