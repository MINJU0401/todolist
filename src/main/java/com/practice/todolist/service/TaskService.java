package com.practice.todolist.service;

import org.springframework.http.ResponseEntity;

import com.practice.todolist.dto.request.PatchTaskRequestDto;
import com.practice.todolist.dto.request.PostTaskRequestDto;
import com.practice.todolist.dto.response.GetFinishedTaskListResponseDto;
import com.practice.todolist.dto.response.GetPassTaskListResponseDto;
import com.practice.todolist.dto.response.GetSearchTaskListResponseDto;
import com.practice.todolist.dto.response.GetUnfinishedTaskListResponseDto;
import com.practice.todolist.dto.response.ResponseDto;

public interface TaskService {  
  
  public ResponseEntity<ResponseDto> postTask(PostTaskRequestDto dto);

  public ResponseEntity<? super GetUnfinishedTaskListResponseDto> getUnfinishedTaskList();

  public ResponseEntity<? super GetFinishedTaskListResponseDto> getFinishedTaskList();

  public ResponseEntity<? super GetPassTaskListResponseDto> getPassTaskList();

  public ResponseEntity<? super GetSearchTaskListResponseDto> getCategorySearchList();

  public ResponseEntity<? super GetSearchTaskListResponseDto> getTaskNameSearchList();

  public ResponseEntity<? super GetSearchTaskListResponseDto> getDateSearchList();

  public ResponseEntity<ResponseDto> patchTask(PatchTaskRequestDto dto);

  public ResponseEntity<ResponseDto> deleteTask(Integer number);

  public ResponseEntity<ResponseDto> patchTaskStatus(Integer number);

}
