package com.practice.todolist.service.implement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.practice.todolist.common.util.CustomResponse;
import com.practice.todolist.dto.request.PatchTaskRequestDto;
import com.practice.todolist.dto.request.PatchTaskStatusRequestDto;
import com.practice.todolist.dto.request.PostTaskRequestDto;
import com.practice.todolist.dto.response.GetFinishedTaskListResponseDto;
import com.practice.todolist.dto.response.GetPassTaskListResponseDto;
import com.practice.todolist.dto.response.GetSearchTaskListResponseDto;
import com.practice.todolist.dto.response.GetUnfinishedTaskListResponseDto;
import com.practice.todolist.dto.response.ResponseDto;
import com.practice.todolist.entity.CategoryEntity;
import com.practice.todolist.entity.TaskEntity;
import com.practice.todolist.entity.resultSet.TaskListResultSet;
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

      if (taskName.isBlank() || date.isBlank() || category.isBlank() || time.isBlank()) {
        return CustomResponse.inputDataError();
      }

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
      LocalDateTime inputDateTime = LocalDateTime.parse(date + " " + time, formatter);
      LocalDateTime currentDateTime = LocalDateTime.now();

      if (inputDateTime.isBefore(currentDateTime)) {
        return CustomResponse.pastDateTimeError();
      }

      TaskEntity taskEntity = taskRepository.findByDateAndTime(date, time);

      if (taskEntity != null) {
        return CustomResponse.scheduleConflictError();
    }

      taskEntity = new TaskEntity();
      taskEntity.setTaskName(taskName);
      taskEntity.setDate(date);
      taskEntity.setTime(time);
      taskEntity.setCategory(category);
      
      taskRepository.save(taskEntity);
        
      return CustomResponse.success();

    } catch(Exception exception) {
      exception.printStackTrace();
      return CustomResponse.databaseError();
    }

  }

  @Override
  public ResponseEntity<? super GetUnfinishedTaskListResponseDto> getUnfinishedTaskList() {
    GetUnfinishedTaskListResponseDto body = null;

    try {
      List<TaskListResultSet> resultSet = taskRepository.getUnfinishedTaskList();
      body = new GetUnfinishedTaskListResponseDto(resultSet);
      return CustomResponse.success(body);

    } catch(Exception exception) {
      exception.printStackTrace();
      return CustomResponse.databaseError();
    }
  }

  @Override
  public ResponseEntity<? super GetFinishedTaskListResponseDto> getFinishedTaskList() {
    GetFinishedTaskListResponseDto body = null;

    try {
      List<TaskListResultSet> resultSet = taskRepository.getFinishedTaskList();
      body = new GetFinishedTaskListResponseDto(resultSet);
      return CustomResponse.success(body);

    } catch(Exception exception) {
      exception.printStackTrace();
      return CustomResponse.databaseError();
    }
  }

  @Override
  public ResponseEntity<? super GetPassTaskListResponseDto> getPassTaskList() {
    GetPassTaskListResponseDto body = null;

    try {
      List<TaskListResultSet> resultSet = taskRepository.getPassTaskList();
      body = new GetPassTaskListResponseDto(resultSet);
      return CustomResponse.success(body);

    } catch(Exception exception) {
      exception.printStackTrace();
      return CustomResponse.databaseError();
    }
  }

  @Override
  public ResponseEntity<? super GetSearchTaskListResponseDto> getCategorySearchList(String category) {
    GetSearchTaskListResponseDto body = null;

    if (category == null || category.isEmpty()) {
        return CustomResponse.inputDataError();
    } else {
        CategoryEntity existCategory = categoryRepository.findByCategory(category);
        if (existCategory == null) {
            return CustomResponse.inputDataError();
        }
    }

    try {      
      List<TaskListResultSet> resultSet = taskRepository.findByTaskContainsCategory(category);
      body = new GetSearchTaskListResponseDto(resultSet); 
      return CustomResponse.success(body);

    } catch(Exception exception) {
      exception.printStackTrace();
      return CustomResponse.databaseError();
    }
  }

  @Override
  public ResponseEntity<? super GetSearchTaskListResponseDto> getTaskNameSearchList(String taskName) {
    GetSearchTaskListResponseDto body = null;

    try {
      List<TaskListResultSet> resultSet = taskRepository.findByTaskContainsTaskName(taskName);
      body = new GetSearchTaskListResponseDto(resultSet); 
      return CustomResponse.success(body);

    } catch(Exception exception) {
      exception.printStackTrace();
      return CustomResponse.databaseError();
    }
  }

  @Override
  public ResponseEntity<? super GetSearchTaskListResponseDto> getDateSearchList(String date) {
    GetSearchTaskListResponseDto body = null;
    
    try {
      List<TaskListResultSet> resultSet = taskRepository.findByTaskContainsDate(date);
      body = new GetSearchTaskListResponseDto(resultSet); 
      return CustomResponse.success(body);

    } catch(Exception exception) {
      exception.printStackTrace();
      return CustomResponse.databaseError();
    }
  }

  @Override
  public ResponseEntity<ResponseDto> patchTask(PatchTaskRequestDto dto) {

    Integer number = dto.getNumber();
    String taskName = dto.getTaskName();
    String date = dto.getDate();
    String category = dto.getCategory();
    String time = dto.getTime();

    try {

      if (number==null || taskName.isBlank() || date.isBlank() || category.isBlank() || time.isBlank()) {
        return CustomResponse.inputDataError();
      }

      TaskEntity taskEntity = taskRepository.findByNumber(number);
      if (taskEntity==null) {
        return CustomResponse.notExistTaskNumber();
      }

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
      LocalDateTime inputDateTime = LocalDateTime.parse(date + " " + time, formatter);
      LocalDateTime currentDateTime = LocalDateTime.now();

      if (inputDateTime.isBefore(currentDateTime)) {
        return CustomResponse.pastDateTimeError();
      }

      TaskEntity taskEntity2 = taskRepository.findByDateAndTime(date, time);

      if (taskEntity2 != null) {
        return CustomResponse.scheduleConflictError();
    }

    taskEntity.setTaskName(taskName);
    taskEntity.setDate(date);
    taskEntity.setTime(time);
    taskEntity.setCategory(category);
    taskRepository.save(taskEntity);
      
    return CustomResponse.success();

    } catch(Exception exception) {
      exception.printStackTrace();
      return CustomResponse.databaseError();
    }

  }

  @Override
  public ResponseEntity<ResponseDto> deleteTask(Integer number) {

    try {
      TaskEntity taskEntity = taskRepository.findByNumber(number);
      if (taskEntity==null) {
        return CustomResponse.notExistTaskNumber();
      }

      taskRepository.delete(taskEntity);
      return CustomResponse.success();

    } catch(Exception exception) {
      exception.printStackTrace();
      return CustomResponse.databaseError();
    }
  }

  @Override
  public ResponseEntity<ResponseDto> patchTaskStatus(PatchTaskStatusRequestDto dto) {
    Integer number = dto.getNumber();

    try {      
      TaskEntity taskEntity = taskRepository.findByNumber(number);
      if (taskEntity==null) {
        return CustomResponse.notExistTaskNumber();
      }

      boolean status = taskEntity.isStatus();
      taskEntity.setStatus(!status);
      taskRepository.save(taskEntity);

      return CustomResponse.success();      

    } catch(Exception exception) {
      exception.printStackTrace();
      return CustomResponse.databaseError();
    }
  }
  
}
