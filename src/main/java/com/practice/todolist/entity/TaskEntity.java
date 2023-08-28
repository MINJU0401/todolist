package com.practice.todolist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.practice.todolist.dto.request.PostTaskRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="task")
@Table(name="task")
public class TaskEntity {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer number;
  private String taskName;
  private String date;
  private String time;
  private String category;
  private boolean status;
  
  public TaskEntity(PostTaskRequestDto dto) {
    this.taskName = getTaskName();
    this.date = getDate();
    this.time = getTime();
    this.category = getCategory();
    this.status = false;
  }
}
