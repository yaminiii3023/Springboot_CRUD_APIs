package org.example.myfirstspringbootproject.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Task {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long task_id;
    private String title;
    private String description;
    private Date due_date;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(length = 100)
    @Enumerated(EnumType.STRING)
    private Category category;

    //MAny to one mapping as many multiple tak assign by one user

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;










}

