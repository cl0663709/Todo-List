package com.example.Todos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Todos.Model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
