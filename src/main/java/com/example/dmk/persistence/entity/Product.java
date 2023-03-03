package com.example.dmk.persistence.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue
  @Column(name = "id")
  Long id;

  @Column(name = "name")
  String name;

  @Column(name = "description")
  String description;

  @Column(name = "picture")
  String picture;

  @Column(name = "price")
  Double price;

  @Column(name = "size")
  String size;

  @Enumerated(EnumType.STRING)
  @Column(name = "type")
  Type type;

  @Column(name = "quantity")
  Integer quantity;
}
