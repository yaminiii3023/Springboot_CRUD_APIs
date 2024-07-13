package org.example.myfirstspringbootproject.DTO;

import lombok.*;
import org.example.myfirstspringbootproject.Entity.User;

import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class TaskDTO {
    private Long task_id;
    private String title;
    private String description;
    private Date due_date;
    private Long user_id;
    private String category;
    private String status;



}
