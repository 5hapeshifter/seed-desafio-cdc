package com.desafio1.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class ValidationErrorsHandler {

    // Objeto para captar as mensagens de validacao declaradas nos DTO's
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ValidationErrorsOutputDto> validationErrors(MethodArgumentNotValidException exception) {
        List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        return ResponseEntity.badRequest().body(
                buildValidationErrorsOutputDto(globalErrors, fieldErrors)
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> persistenErrors(PersistenceException exception) {


        return ResponseEntity.badRequest().body(exception.getCause().getMessage());

    }

    private ValidationErrorsOutputDto buildValidationErrorsOutputDto(List<ObjectError> globalErrors,
                                                                     List<FieldError> fields) {
        ValidationErrorsOutputDto validationErrors = new ValidationErrorsOutputDto();
        globalErrors.forEach(objectError -> validationErrors.addError(getErrorMessage(objectError)));

        fields.forEach(fieldError -> {
            String errorMessage = getErrorMessage(fieldError);
            validationErrors.addFieldError(fieldError.getField(), errorMessage);
        });
        return validationErrors;
    }

    private String getErrorMessage(ObjectError objectError) {
        return messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
    }
}
