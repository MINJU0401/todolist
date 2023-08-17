package com.practice.todolist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
  private int number;
  private String taskName;
  private String date;
  private String time;
  private String category;
  private boolean status;
  
}
