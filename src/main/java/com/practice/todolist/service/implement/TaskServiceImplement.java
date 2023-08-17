package com.practice.todolist.service.implement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.todolist.common.util.CustomResponse;
import com.practice.todolist.dto.request.PatchTaskRequestDto;
import com.practice.todolist.dto.request.PostTaskRequestDto;
import com.practice.todolist.dto.response.GetFinishedTaskListResponseDto;
import com.practice.todolist.dto.response.GetPassTaskListResponseDto;
import com.practice.todolist.dto.response.GetSearchTaskListResponseDto;
import com.practice.todolist.dto.response.GetUnfinishedTaskListResponseDto;
import com.practice.todolist.dto.response.ResponseDto;
import com.practice.todolist.entity.TaskEntity;
import com.practice.todolist.repository.CategoryRepository;
import com.practice.todolist.repository.TaskRepository;
import com.practice.todolist.service.TaskService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImplement implements TaskService {

  private final TaskRepository taskRepository;
  private final CategoryRepository categoryRepository;

  @Override
  public ResponseEntity<ResponseDto> postTask(PostTaskRequestDto dto) {

    String taskName = dto.getTaskName();
    String date = dto.getDate();
    String category = dto.getCategory();
    String time = dto.getTime();

    try {

      if (taskName==null || date==null || category==null || time==null) {
        return CustomResponse.inputDataError();
      }

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
      LocalDateTime inputDateTime = LocalDateTime.parse(date + " " + time, formatter);
      LocalDateTime currentDateTime = LocalDateTime.now();

      if (inputDateTime.isBefore(currentDateTime)) {
        return CustomResponse.pastDateTimeError();
      }

      TaskEntity existingTask = taskRepository.findByDateAndTime(date, time);

      if (existingTask != null) {
        return CustomResponse.scheduleConflictError();
    }
      
    return CustomResponse.success();

    } catch(Exception exception) {
      exception.printStackTrace();
      return CustomResponse.databaseError();
    }

  }

  @Override
  public ResponseEntity<? super GetUnfinishedTaskListResponseDto> getUnfinishedTaskList() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getUnfinishedTaskList'");
  }

  @Override
  public ResponseEntity<? super GetFinishedTaskListResponseDto> getFinishedTaskList() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getFinishedTaskList'");
  }

  @Override
  public ResponseEntity<? super GetPassTaskListResponseDto> getPassTaskList() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getPassTaskList'");
  }

  @Override
  public ResponseEntity<? super GetSearchTaskListResponseDto> getCategorySearchList() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCategorySearchList'");
  }

  @Override
  public ResponseEntity<? super GetSearchTaskListResponseDto> getTaskNameSearchList() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getTaskNameSearchList'");
  }

  @Override
  public ResponseEntity<? super GetSearchTaskListResponseDto> getDateSearchList() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getDateSearchList'");
  }

  @Override
  public ResponseEntity<ResponseDto> patchTask(PatchTaskRequestDto dto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'patchTask'");
  }

  @Override
  public ResponseEntity<ResponseDto> deleteTask(Integer number) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteTask'");
  }

  @Override
  public ResponseEntity<ResponseDto> patchTaskStatus(Integer number) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'patchTaskStatus'");
  }
  
}
