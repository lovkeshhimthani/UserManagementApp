package net.javaguides.springboot_restful_webservices.mapper;

import net.javaguides.springboot_restful_webservices.dto.UserDto;
import net.javaguides.springboot_restful_webservices.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {


    AutoUserMapper MAPPER= Mappers.getMapper(AutoUserMapper.class);

    //    @Mapping(source = "email" target="emailAddress")

    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);
}
