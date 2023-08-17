package com.practice.todolist.service;

import org.springframework.http.ResponseEntity;

import com.practice.todolist.dto.request.PatchTaskRequestDto;
import com.practice.todolist.dto.request.PatchTaskStatusRequestDto;
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

  public ResponseEntity<? super GetSearchTaskListResponseDto> getCategorySearchList(String category);

  public ResponseEntity<? super GetSearchTaskListResponseDto> getTaskNameSearchList(String taskName);

  public ResponseEntity<? super GetSearchTaskListResponseDto> getDateSearchList(String date);

  public ResponseEntity<ResponseDto> patchTask(PatchTaskRequestDto dto);

  public ResponseEntity<ResponseDto> deleteTask(Integer number);

  public ResponseEntity<ResponseDto> patchTaskStatus(PatchTaskStatusRequestDto dto);

}
