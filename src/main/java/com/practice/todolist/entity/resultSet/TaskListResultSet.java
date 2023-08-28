package com.practice.todolist.entity.resultSet;

public interface TaskListResultSet {

  public Integer getNumber();
  public String getTaskName();
  public String getDate();
  public String getTime();
  public String getCategory();
  public Byte getStatus();
}
