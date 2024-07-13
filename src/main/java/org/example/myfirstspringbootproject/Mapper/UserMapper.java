package org.example.myfirstspringbootproject.Mapper;

import org.example.myfirstspringbootproject.DTO.UserDTO;
import org.example.myfirstspringbootproject.Entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;

    public User convertUserdtoToUser(UserDTO userdto) {
        User user = modelMapper.map(userdto, User.class);
        return user;
    }
    public UserDTO convertUserToUserDTO(User user) {
        UserDTO userDTO=modelMapper.map(user,UserDTO.class);
        return userDTO;
    }
}
