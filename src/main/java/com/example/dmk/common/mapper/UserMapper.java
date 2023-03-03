package com.example.dmk.common.mapper;

import com.example.dmk.model.dto.UserDto;
import com.example.dmk.persistence.entity.DmkUser;
import com.example.dmk.model.dto.NewUserDto;
import org.mapstruct.Mapper;

/**
 * This interface defines methods for mapping between the {@link DmkUser},
 * {@link UserDto}
 * and {@link NewUserDto}classes.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

  /**
   * Maps a {@link NewUserDto} object to a {@link DmkUser} object.
   *
   * @param newUserDto The {@link NewUserDto} object to be mapped.
   * @return The resulting {@link DmkUser} object.
   */
  DmkUser newUserDtoToDmkUser(NewUserDto newUserDto);

  /**
   * Maps a {@link UserDto} object to a {@link DmkUser} object.
   *
   * @param userDto The {@link UserDto} object to be mapped.
   * @return The resulting {@link DmkUser} object.
   */
  DmkUser userDtoToDmkUser(UserDto userDto);

  /**
   * Maps a {@link DmkUser} object to a {@link UserDto} object.
   *
   * @param dmkUser The {@link DmkUser} object to be mapped.
   * @return The resulting {@link UserDto} object.
   */
  UserDto dmkUserToUserDto(DmkUser dmkUser);
}
