package org.example.myfirstspringbootproject.Repository;

import org.example.myfirstspringbootproject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface UserRepo extends JpaRepository<User, Long> {
//        public User findByUsername(String username);
    }

