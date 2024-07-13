package org.example.myfirstspringbootproject.DTO;

import lombok.*;
import org.example.myfirstspringbootproject.Entity.Task;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private Long user_id;
    private String user_name;
    private String user_email;
    private int password;


}
