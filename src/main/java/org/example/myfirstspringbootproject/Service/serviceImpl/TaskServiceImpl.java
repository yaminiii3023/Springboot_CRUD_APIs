package org.example.myfirstspringbootproject.Service.serviceImpl;

import org.example.myfirstspringbootproject.DTO.TaskDTO;
import org.example.myfirstspringbootproject.Entity.Category;
import org.example.myfirstspringbootproject.Entity.Status;
import org.example.myfirstspringbootproject.Entity.Task;
import org.example.myfirstspringbootproject.Entity.User;
import org.example.myfirstspringbootproject.ExceptionalHandling.ResourceNotFoundException;
import org.example.myfirstspringbootproject.Mapper.TaskMapper;
import org.example.myfirstspringbootproject.Mapper.UserMapper;
import org.example.myfirstspringbootproject.Repository.TaskRepo;
import org.example.myfirstspringbootproject.Service.serviceInterface.TaskServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskServiceInterface {
    @Autowired
    private ModelMapper modelmapper;
    @Autowired
    private TaskRepo taskrepo;
    @Autowired
    private TaskMapper taskmapper;
    @Autowired
    private TaskRepo taskRepo;

    @Override
    public TaskDTO createTask(TaskDTO taskdto) {
      Task task = taskmapper.convertTaskDTOtoTask(taskdto);
      taskRepo.save(task);
      return taskmapper.convertTasktoTaskDTO(task);
    }

    @Override
    public TaskDTO findTaskById(Long id) {
        Task task= taskRepo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("task is not found")
        );
        return taskmapper.convertTasktoTaskDTO(task);
    }

    @Override
    public List<TaskDTO> getAllTask() {
        List<Task> task=taskRepo.findAll();
        return task.stream().map((activity)->taskmapper.convertTasktoTaskDTO(activity)).toList();
    }

    @Override
    public TaskDTO updateTask(TaskDTO taskdto, Long id) {
        Task task=taskRepo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("task is not found")
        );
        task.setTitle(taskdto.getTitle());
        task.setDescription(taskdto.getDescription());
        task.setDue_date(taskdto.getDue_date());
        task.setCategory(Category.valueOf(taskdto.getCategory()));
        task.setStatus(Status.valueOf(taskdto.getStatus()));
        Task updatetask=taskRepo.save(task);
        return taskmapper.convertTasktoTaskDTO(updatetask);

    }

    @Override
    public TaskDTO deleteTask(Long id) {
        Task task=taskRepo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("task is not found")
        );
        taskRepo.delete(task);
        return taskmapper.convertTasktoTaskDTO(task);
    }
}



