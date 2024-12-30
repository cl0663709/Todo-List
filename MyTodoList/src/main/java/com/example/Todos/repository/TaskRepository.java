package com.example.Todos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Todos.Model.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
