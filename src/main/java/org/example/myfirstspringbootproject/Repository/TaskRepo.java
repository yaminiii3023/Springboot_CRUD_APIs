package org.example.myfirstspringbootproject.Repository;

import org.example.myfirstspringbootproject.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task,Long> {
}
