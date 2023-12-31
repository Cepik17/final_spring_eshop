package com.example.demo.mappers;

import com.example.demo.dtos.UserCreate;
import com.example.demo.dtos.UserView;
import com.example.demo.models.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
 //   UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserCreate dto);
   UserView toView(User user);
   User toEntity(UserView userView);
}
