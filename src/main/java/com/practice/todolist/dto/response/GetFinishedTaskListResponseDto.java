package com.practice.todolist.dto.response;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetFinishedTaskListResponseDto {

  private String taskName;
  private String date;
  private String time;
  private String category;

}
