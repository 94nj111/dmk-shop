package com.example.dmk.persistence.reposirory;

import com.example.dmk.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> getAllByType(String type);
}
