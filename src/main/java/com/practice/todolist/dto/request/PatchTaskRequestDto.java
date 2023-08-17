package com.practice.todolist.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchTaskRequestDto {
  
  @NotNull
  private Integer number;
  @NotBlank
  private String taskName;
  @NotBlank
  private String date;
  @NotBlank
  private String time;
  @NotBlank
  private String category;

}
