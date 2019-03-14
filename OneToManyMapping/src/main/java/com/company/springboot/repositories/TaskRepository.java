package com.company.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.springboot.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
