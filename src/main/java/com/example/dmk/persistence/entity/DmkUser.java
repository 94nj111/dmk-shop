package com.example.dmk.persistence.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "dmk_users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DmkUser {

  @Id
  @GeneratedValue
  @Column(name = "id")
  Long id;

  @Column(name = "name")
  String name;

  /**
   * We would use email as username
   */
  @Column(name = "username")
  String username;

  @Column(name = "phone_number")
  String phoneNumber;

  @Enumerated(EnumType.STRING)
  @Column(name = "user_role")
  UserRole userRole;

  @Column(name = "password")
  String password;
}
