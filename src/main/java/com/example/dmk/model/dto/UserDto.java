package com.example.dmk.model.dto;

import com.example.dmk.persistence.entity.UserRole;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

  String name;

  String username;

  String phoneNumber;

  UserRole userRole;
}
