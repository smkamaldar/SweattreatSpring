package com.shop.sweattreat.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    whenever you face methodArg.... class redirect it to this method
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArg(MethodArgumentNotValidException ex){
//        we need to extract the ex message and map it and return to the end user
//        1) creat a map object
        Map<String,String> errMap = new HashMap<>();
//        2)by ex we are getting all field that have issue just need to extract it and put it in map
        ex.getBindingResult().getFieldErrors().forEach(err->{
            errMap.put(err.getField(),err.getDefaultMessage());
        });
                return errMap;

    }
}
