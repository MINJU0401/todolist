package com.practice.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.todolist.dto.request.PostTaskRequestDto;
import com.practice.todolist.entity.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
  
  TaskEntity findByDateAndTime(String date, String time);

}
