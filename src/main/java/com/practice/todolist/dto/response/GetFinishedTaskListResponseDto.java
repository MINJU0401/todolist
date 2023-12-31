package com.practice.todolist.dto.response;


import java.util.ArrayList;
import java.util.List;

import com.practice.todolist.entity.resultSet.TaskListResultSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetFinishedTaskListResponseDto extends ResponseDto {

  private List<Tasks> taskList;
  
  public GetFinishedTaskListResponseDto (List<TaskListResultSet> resultSet) {
    super("SU", "SUCCESS");

    List<Tasks> taskList = new ArrayList<>();

    for (TaskListResultSet result: resultSet) {
        Tasks tasks = new Tasks(result);
        taskList.add(tasks);
  }
  this.taskList = taskList;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Tasks {
  private Integer number;
  private String taskName;
  private String date;
  private String time;
  private String category;

  public Tasks(TaskListResultSet resultSet) {
    this.number = resultSet.getNumber();
    this.taskName = resultSet.getTaskName();
    this.date = resultSet.getDate();
    this.time = resultSet.getTime();
    this.category = resultSet.getCategory();
  }
}

}
