package org.example.myfirstspringbootproject.Service.serviceInterface;

import org.example.myfirstspringbootproject.DTO.UserDTO;

import java.util.List;

public interface UserServiceInterface {
    public UserDTO createUser(UserDTO userdto);
    public UserDTO findUserById(Long id);
    public List<UserDTO> getAllUsers();
    public UserDTO updateUser(UserDTO userdto, Long id);
    UserDTO deleteUser(Long id);
//   void deleteAllUser(Long id);
}
