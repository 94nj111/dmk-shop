package com.example.dmk.persistence.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "sales_products")
public class SalesProduct {

  @Id
  @GeneratedValue
  Long id;

  @Column(name = "product_id")
  Long productId;

  @Column(name = "quantity")
  Integer quantity;

  @ManyToOne
  @JoinColumn(name = "cart_id")
  Cart cart;
}
