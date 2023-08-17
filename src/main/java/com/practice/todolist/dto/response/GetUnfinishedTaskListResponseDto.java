package com.practice.todolist.dto.response;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetUnfinishedTaskListResponseDto {
  
  private String taskName;
  private String date;
  private String time;
  private String category;

}
