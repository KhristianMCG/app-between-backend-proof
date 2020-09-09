package com.proof.between.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.ParseException;

@ControllerAdvice
public class ExceptionHandlers {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlers.class);

    @ExceptionHandler
    public ResponseEntity<String> handle(final BetweenProofException ex) {
        LOGGER.warn(ex.getMessage(), ex);
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(final NumberFormatException ex) {
        LOGGER.warn(ErrorTypeCode.BRAND_ID_OR_PRODUCT_ID_NOT_VALID.getDescription(), ex);
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(final ParseException ex) {
        LOGGER.warn(ErrorTypeCode.DATE_NOT_VALID.getDescription(), ex);
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
