package org.example.myfirstspringbootproject.Controller;

import org.example.myfirstspringbootproject.DTO.UserDTO;
// import org.example.myfirstspringbootproject.Entity.*;
import org.example.myfirstspringbootproject.Service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    private UserServiceImpl userserviceimpl;

    @CrossOrigin(origins = "http://localhost:3003")
    @PostMapping("/create-user") //json object to java
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userdto) {
        UserDTO userdto1 = userserviceimpl.createUser(userdto); //saving data into databse
        return new ResponseEntity<>(userdto1, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3003")
    @GetMapping("/get-user/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        UserDTO userdto = userserviceimpl.findUserById(id);
        return ResponseEntity.ok(userdto);

    }
    @CrossOrigin(origins = "http://localhost:3003")
    @GetMapping("/get-user")
    public List<UserDTO> getAllUsers()
    {
        return userserviceimpl.getAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:3003")
    @PutMapping("/update-user/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userdto,@PathVariable Long id) {
        UserDTO userdto1 = userserviceimpl.updateUser(userdto,id);
        return ResponseEntity.ok(userdto1);
    }

    @CrossOrigin(origins = "http://localhost:3003")
    @DeleteMapping("/delete-user/{id}")
    //@PathVariable("id") --is for mapping the Long id so we can change it Long id to any name
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userserviceimpl.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }


}
