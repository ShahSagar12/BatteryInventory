package com.inventory.controller;

import com.inventory.model.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * This class is a part of the package com.inventory.controller and the package
 * is a part of the project BatteryInventory.
 * <p>
 * Connecting Creations Pvt. Ltd. Lalitpur, Nepal.
 * https://c2.my/
 * <p>
 * Created by sagar on 2022-12-09.
 */
@ControllerAdvice
@EnableWebMvc
public class ExceptionController extends ResponseEntityExceptionHandler {

    /**
     * handleException - Handles all the Exception recieving a request, responseDto.
     *@param request
     *@param responseDto
     *@return ResponseEntity<ResponseDto>
     */
    @ExceptionHandler(value = { Exception.class })
    public @ResponseBody ResponseEntity<ResponseDto> handleException(HttpServletRequest request,
                                                                     ResponseDto responseDto){

        return ResponseEntity.ok(responseDto);
    }

    /**
     * handleIOException - Handles all the I/O Exceptions of the application.
     *@param request
     *@param exception
     *@return ResponseEntity<ResponseDto>
     *
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseDto> handleIOException(HttpServletRequest request, RuntimeException exception){


        return ResponseEntity.ok(
                ResponseDto.builder()
                        .status(false)
                        .error(exception.getMessage())
                        .message(exception.getMessage())
                        .result(null)
                        .build()
        );
    }
}
