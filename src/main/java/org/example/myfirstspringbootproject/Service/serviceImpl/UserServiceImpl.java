package org.example.myfirstspringbootproject.Service.serviceImpl;

import org.example.myfirstspringbootproject.DTO.UserDTO;
import org.example.myfirstspringbootproject.Entity.User;
import org.example.myfirstspringbootproject.ExceptionalHandling.ResourceNotFoundException;
import org.example.myfirstspringbootproject.Mapper.UserMapper;
import org.example.myfirstspringbootproject.Repository.UserRepo;
import org.example.myfirstspringbootproject.Service.serviceInterface.UserServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserMapper usermapper;
    @Autowired
    private ModelMapper modelmapper;
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDTO createUser(UserDTO userdto) {
       User user =usermapper.convertUserdtoToUser(userdto);
       userRepo.save(user);
       return usermapper.convertUserToUserDTO(user);
    }

    @Override
    public UserDTO findUserById(Long id) {
       User user= userRepo.findById(id).orElseThrow(
               ()-> new ResourceNotFoundException("user not found by this is")
       );
       return usermapper.convertUserToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
       List<User> user=userRepo.findAll();
       return user.stream().map((employee)->usermapper.convertUserToUserDTO(employee)).toList();

    }

    @Override
    public UserDTO updateUser(UserDTO userdto, Long id) {
        User user=userRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("user by this id is not in DB")
        );
        user.setUser_name(userdto.getUser_name());
        User updateduser =userRepo.save(user);
        return usermapper.convertUserToUserDTO(updateduser);
    }

    @Override
    public UserDTO deleteUser(Long id) {
        User user=userRepo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("user is not found")
        );
        userRepo.delete(user);
        return usermapper.convertUserToUserDTO(user);
    }

//    @Override
//    public void deleteAllUser(Long id) {
//        User user=userRepo.findById(id).orElseThrow(
//                ()->new ResourceNotFoundException("user is not found")
//        );
//        User deleteduser =userRepo.save(user);
//        return;
//    }
}
