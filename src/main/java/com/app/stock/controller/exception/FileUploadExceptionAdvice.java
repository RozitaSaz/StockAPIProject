package com.app.stock.controller.exception;

import com.app.stock.message.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by Rozita on 10/18/21.
 */
@ControllerAdvice
public class FileUploadExceptionAdvice extends ResponseEntityExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(FileUploadExceptionAdvice.class);

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity handleMaxSizeException(MaxUploadSizeExceededException exc) {
        log.error("File too large! " + exc.getMessage());
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File too large!"));
    }
}