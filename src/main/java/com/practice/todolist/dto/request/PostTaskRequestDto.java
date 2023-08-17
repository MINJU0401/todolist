package com.practice.todolist.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostTaskRequestDto {

  @NotBlank
  private String taskName;
  @NotBlank
  private String date;
  @NotBlank
  private String time;
  @NotBlank
  private String category;
}
