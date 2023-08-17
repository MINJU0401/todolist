package com.practice.todolist.common.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.practice.todolist.dto.response.GetUnfinishedTaskListResponseDto;
import com.practice.todolist.dto.response.ResponseDto;

public class CustomResponse {

    public static <T extends ResponseDto> ResponseEntity<T> success(T body) {
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    public static ResponseEntity<ResponseDto> success() {
        ResponseDto body = new ResponseDto("SU", "SUCCESS");
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    public static ResponseEntity<ResponseDto> databaseError() {

        ResponseDto errorBody = new ResponseDto("DE", "Database Error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);

    }

    public static ResponseEntity<ResponseDto> inputDataError() {
        ResponseDto errorBody = new ResponseDto("IE", "Insufficient input data error");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);

    }

    
    public static ResponseEntity<ResponseDto> scheduleConflictError() {
        ResponseDto errorBody = new ResponseDto("SE", "A schedule already exists at the same date and time");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);

    }
        
    public static ResponseEntity<ResponseDto> pastDateTimeError() {
        ResponseDto errorBody = new ResponseDto("PE", "The input date and time are in the past");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);

    }

    public static ResponseEntity<ResponseDto> notExistTaskNumber() {
        ResponseDto errorBody = new ResponseDto("NT", "Non-Existent Task Number");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }
}
