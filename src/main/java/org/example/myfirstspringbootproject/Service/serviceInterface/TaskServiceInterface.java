package org.example.myfirstspringbootproject.Service.serviceInterface;

import org.example.myfirstspringbootproject.DTO.TaskDTO;
import org.example.myfirstspringbootproject.DTO.UserDTO;

import java.util.List;

public interface TaskServiceInterface {
    public TaskDTO createTask(TaskDTO taskdto);
    public TaskDTO findTaskById(Long id);
    public List<TaskDTO> getAllTask();
    public TaskDTO updateTask(TaskDTO taskdto, Long id);
    TaskDTO deleteTask(Long id);
}
