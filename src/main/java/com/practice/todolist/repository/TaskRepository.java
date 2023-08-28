package com.practice.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.todolist.dto.request.PostTaskRequestDto;
import com.practice.todolist.entity.TaskEntity;
import com.practice.todolist.entity.resultSet.TaskListResultSet;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
  
  TaskEntity findByDateAndTime(String date, String time);
  TaskEntity findByNumber(int number);

  
  @Query(
    value=
    "SELECT " +
    "T.number AS number, " +
    "T.task_name AS taskName, " +
    "T.date AS date, " +
    "T.time AS time, " +
    "T.category AS category " +
    "FROM task T " +
    "WHERE T.status = false " +
    "ORDER BY T.date DESC",
    nativeQuery=true)
public List<TaskListResultSet> getUnfinishedTaskList();

  @Query(
    value=
    "SELECT " +
    "T.number AS number, " +
    "T.task_name AS taskName, " +
    "T.date AS date, " +
    "T.time AS time, " +
    "T.category AS category " +
    "FROM task T " +
    "WHERE T.status = true " +
    "ORDER BY T.date DESC",
    nativeQuery=true)
public List<TaskListResultSet> getFinishedTaskList();

@Query(
  value=
  "SELECT " +
  "T.number AS number, " +
  "T.task_name AS taskName, " +
  "T.date AS date, " +
  "T.time AS time, " +
  "T.category AS category, " +
  "T.status AS status " +
  "FROM task T " +
  "WHERE T.date < CURRENT_DATE " + 
  "ORDER BY T.date ASC ",
  nativeQuery = true)
public List<TaskListResultSet> getPassTaskList();

@Query(value = "SELECT " +
"T.number AS number, " +
"T.task_name AS taskName, " +
"T.date AS date, " +
"T.time AS time, " +
"T.category AS category, " +
"T.status AS status " +
"FROM task T " +
"WHERE T.category = ? " +
"ORDER BY T.date DESC ", nativeQuery = true)
public List<TaskListResultSet> findByTaskContainsCategory(String category);

@Query(value = "SELECT " +
"T.number AS number, " +
"T.task_name AS taskName, " +
"T.date AS date, " +
"T.time AS time, " +
"T.category AS category, " +
"T.status AS status " +
"FROM task T " +
"WHERE T.task_name = ? " +
"ORDER BY T.date DESC ", nativeQuery = true)
public List<TaskListResultSet> findByTaskContainsTaskName(String taskName);

@Query(value = "SELECT " +
"T.number AS number, " +
"T.task_name AS taskName, " +
"T.date AS date, " +
"T.time AS time, " +
"T.category AS category, " +
"T.status AS status " +
"FROM task T " +
"WHERE T.date = ? " +
"ORDER BY T.date DESC ", nativeQuery = true)
public List<TaskListResultSet> findByTaskContainsDate(String date);
}

