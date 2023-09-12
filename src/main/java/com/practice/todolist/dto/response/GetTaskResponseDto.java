package com.practice.todolist.dto.response;

import com.practice.todolist.entity.TaskEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GetTaskResponseDto extends ResponseDto {
  
  private Integer number;
  private String taskName;
  private String date;
  private String time;
  private String category;
  private Boolean status;

  public GetTaskResponseDto(TaskEntity taskEntity) {
    super("SU", "SUCCESS");

    this.number = taskEntity.getNumber();
    this.taskName = taskEntity.getTaskName();
    this.date = taskEntity.getDate();
    this.time = taskEntity.getTime();
    this.category = taskEntity.getCategory();
    this.status = taskEntity.isStatus();

  }
}
