package com.example.dmk.persistence.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "carts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cart {

  @Id
  @GeneratedValue
  Long id;

  @Column(name = "name")
  String name;

  @Column(name = "phone_number")
  String phoneNumber;

  @Column(name = "email")
  String email;

  @Column(name = "delivery_type")
  @Enumerated(value = EnumType.STRING)
  DeliveryType deliveryType;

  @Column(name = "delivery_address")
  String deliveryAddress;

  @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
  List<SalesProduct> salesProductList;

  @CreatedDate
  @Column(name = "created")
  Date created;

  @Column(name = "total_cost")
  Double totalCost;
}
