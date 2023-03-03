package com.example.dmk.api.rest.controller;

import com.example.dmk.common.mapper.UserMapper;
import com.example.dmk.model.dto.NewUserDto;
import com.example.dmk.model.dto.UserDto;
import com.example.dmk.persistence.entity.UserRole;
import com.example.dmk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;
  private final UserMapper userMapper;

  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
  @GetMapping()
  public ResponseEntity<UserDto> getUser(@AuthenticationPrincipal final User user) {
    final var dmkUser = userService.getByUsername(user.getUsername());
    final var userResponse = userMapper.dmkUserToUserDto(dmkUser);
    return ResponseEntity.ok().body(userResponse);
  }

  @GetMapping("/is-admin")
  public ResponseEntity<Boolean> isAdmin(@AuthenticationPrincipal final User user) {
    if (user == null) {
      return ResponseEntity.badRequest().body(false);
    }
    final var dmkUser = userService.getByUsername(user.getUsername());
    return dmkUser.getUserRole().equals(UserRole.ADMIN) ? ResponseEntity.ok().body(true) : ResponseEntity.badRequest().body(false);
  }

  @PermitAll
  @PostMapping("/sign-up")
  public ResponseEntity<UserDto> createUser(@RequestBody NewUserDto newUserDto) {
    final var dmkUser = userMapper.newUserDtoToDmkUser(newUserDto);
    if (userService.isExist(dmkUser)) {
      return ResponseEntity.badRequest().build();
    }
    final var createdUser = userService.createUser(dmkUser);
    final var userResponse = userMapper.dmkUserToUserDto(createdUser);
    return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
  }
}
