package com.flight.inventory.ExceptionHandler;


import com.flight.inventory.Controllers.FlightController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {

        logger.error("An unexpected error occurred: {}", e.getMessage(), e);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred. Please try again later.");

    }


    // Handle specific exceptions if needed (e.g., NullPointerException)

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException e) {

        logger.error("Null pointer exception: {}", e.getMessage(), e);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("A required value was missing. Please contact support.");
    }


    // Handle IllegalArgumentException

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {

        logger.warn("Validation failed: {}", e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());

    }
}
