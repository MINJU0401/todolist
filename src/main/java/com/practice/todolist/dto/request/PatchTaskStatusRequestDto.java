package com.practice.todolist.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchTaskStatusRequestDto {

  @NotNull
  private Integer number;

}
