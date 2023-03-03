package com.example.dmk.common.mapper;

import com.example.dmk.model.dto.CartDto;
import com.example.dmk.persistence.entity.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {

  Cart cartDtoToCart(CartDto cartDto);

  CartDto cartToCartDto(Cart cart);
}
