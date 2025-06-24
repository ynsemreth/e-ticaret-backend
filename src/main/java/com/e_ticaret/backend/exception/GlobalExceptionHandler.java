package com.e_ticaret.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex) {
        logger.error("Hata:", ex);  
        return new ResponseEntity<>("Sunucu hatası oluştu", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
