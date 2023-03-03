package com.example.dmk.service;

import com.example.dmk.persistence.entity.Cart;
import com.example.dmk.persistence.entity.SalesProduct;
import java.util.List;

public interface CartValidatorService {

  List<SalesProduct> isValid(Cart cart);
}
