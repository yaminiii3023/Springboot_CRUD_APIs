package org.example.myfirstspringbootproject.Configurations;

import org.example.myfirstspringbootproject.Service.serviceImpl.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public UserServiceImpl userserviceimpl()
    {
        return new UserServiceImpl();
    }


    @Bean
    public TaskServiceImpl taskserviceimpl()
    {
        return new TaskServiceImpl();
    }




}
