package org.example.myfirstspringbootproject.Controller;

import org.example.myfirstspringbootproject.DTO.TaskDTO;
// import org.example.myfirstspringbootproject.DTO.UserDTO;
import org.example.myfirstspringbootproject.Service.serviceImpl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")

public class TaskController {
    @Autowired
    private TaskServiceImpl taskserviceimpl;

    @CrossOrigin(origins = "http://localhost:3003")
    @PostMapping("/create-task") //json object to java
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskdto) {
        TaskDTO taskdto1 =taskserviceimpl.createTask(taskdto);
        return new ResponseEntity<>(taskdto1,HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3003")
    @GetMapping("/get-task/{id}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable Long id) {
       TaskDTO taskdto = taskserviceimpl.findTaskById(id);
        return ResponseEntity.ok(taskdto);

    }

    @CrossOrigin(origins = "http://localhost:3003")
    @GetMapping("/get-task")
    public List<TaskDTO> getAllTask()
    {
        return taskserviceimpl.getAllTask();
    }

    @CrossOrigin(origins = "http://localhost:3003")
    @PutMapping("/update-task/{id}")
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO taskdto , @PathVariable Long id) {
        TaskDTO taskdto1 = taskserviceimpl.updateTask(taskdto,id);
        return ResponseEntity.ok(taskdto1);
    }

    @CrossOrigin(origins = "http://localhost:3003")
    @DeleteMapping("/delete-task/{id}")
    //@PathVariable("id") --is for mapping the Long id so we can change it Long id to any name
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskserviceimpl.deleteTask(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
