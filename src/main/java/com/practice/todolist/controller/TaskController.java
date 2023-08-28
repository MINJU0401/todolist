package com.practice.todolist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.todolist.dto.request.PatchTaskRequestDto;
import com.practice.todolist.dto.request.PatchTaskStatusRequestDto;
import com.practice.todolist.dto.request.PostTaskRequestDto;
import com.practice.todolist.dto.response.GetFinishedTaskListResponseDto;
import com.practice.todolist.dto.response.GetPassTaskListResponseDto;
import com.practice.todolist.dto.response.GetSearchTaskListResponseDto;
import com.practice.todolist.dto.response.GetUnfinishedTaskListResponseDto;
import com.practice.todolist.dto.response.ResponseDto;
import com.practice.todolist.service.TaskService;

@RestController
@RequestMapping("")
public class TaskController {

  private final TaskService taskService;

  public TaskController(TaskService taskService) {
      this.taskService = taskService;
  }
  
  @PostMapping("")
  public ResponseEntity<ResponseDto> postTask(
      @Valid @RequestBody PostTaskRequestDto requestBody
  ) {
      ResponseEntity<ResponseDto> response = taskService.postTask(requestBody);
      return response;
  }

  @GetMapping("/unfinished")
  public ResponseEntity<? super GetUnfinishedTaskListResponseDto> getUnfinishedTaskList() {
      ResponseEntity<? super GetUnfinishedTaskListResponseDto> response = 
      taskService.getUnfinishedTaskList();
      return response;
  }

  @GetMapping("/finished")
  public ResponseEntity<? super GetFinishedTaskListResponseDto> getFinishedTaskList(){
      ResponseEntity<? super GetFinishedTaskListResponseDto> response = 
      taskService.getFinishedTaskList();
      return response;
  }
  
  @GetMapping("/passed")
  public ResponseEntity<? super GetPassTaskListResponseDto> getPassTaskList(){
      ResponseEntity<? super GetPassTaskListResponseDto> response = 
      taskService.getPassTaskList();
      return response;
  }

  @GetMapping("/search/category")
  public ResponseEntity<? super GetSearchTaskListResponseDto> getCategorySearchList(
    @RequestParam("category") String category
  ){
      ResponseEntity<? super GetSearchTaskListResponseDto> response = 
      taskService.getCategorySearchList(category);
      return response;
  }

  @GetMapping("/search/taskName")
  public ResponseEntity<? super GetSearchTaskListResponseDto> getTaskNameSearchList(
    @RequestParam("taskName") String taskName
  ){
      ResponseEntity<? super GetSearchTaskListResponseDto> response = 
      taskService.getTaskNameSearchList(taskName);
      return response;
  }
  
  @GetMapping("/search/date")
  public ResponseEntity<? super GetSearchTaskListResponseDto> getDateSearchList(
    @RequestParam("date") String date
  ){
      ResponseEntity<? super GetSearchTaskListResponseDto> response = 
      taskService.getDateSearchList(date);
      return response;
  }

  @DeleteMapping("/{number}")
  public ResponseEntity<ResponseDto> deleteTask(
    @RequestBody @PathVariable("number") Integer number
  ) {
      ResponseEntity<ResponseDto> response = taskService.deleteTask(number);
      return response;
  }
  
  @PatchMapping("")
  public ResponseEntity<ResponseDto> patchTask(
      @Valid @RequestBody PatchTaskRequestDto requestBody
  ) {
      ResponseEntity<ResponseDto> response = taskService.patchTask(requestBody);
      return response;
  }
  
  @PatchMapping("/update")
  public ResponseEntity<ResponseDto> patchTaskStatus(
      @Valid @RequestBody PatchTaskStatusRequestDto requestBody
  ) {
      ResponseEntity<ResponseDto> response = taskService.patchTaskStatus(requestBody);
      return response;
  }
}
