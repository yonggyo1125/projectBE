package org.koreait.api.controllers;

import org.koreait.commons.exceptions.CommonException;
import org.koreait.commons.rests.JSONData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("api.controllers")
public class CommonController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<JSONData<Object>> errorHandler(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (e instanceof CommonException) {
            CommonException commonException = (CommonException) e;
            status = commonException.getStatus();
        }

        JSONData<Object> data = new JSONData<>();
        data.setSuccess(false);
        data.setStatus(status);
        data.setMessage(e.getMessage());

        e.printStackTrace();

        return ResponseEntity.status(status).body(data);
    }
}
