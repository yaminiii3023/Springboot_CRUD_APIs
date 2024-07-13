package org.example.myfirstspringbootproject.Mapper;

import org.example.myfirstspringbootproject.DTO.TaskDTO;
import org.example.myfirstspringbootproject.Entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Task convertTaskDTOtoTask(TaskDTO taskdto)
    {
        Task task=modelMapper.map(taskdto,Task.class);
        return task;
    }

    public TaskDTO convertTasktoTaskDTO(Task task)
    {
        TaskDTO taskdto=modelMapper.map(task, TaskDTO.class);
        return taskdto;
    }
}
