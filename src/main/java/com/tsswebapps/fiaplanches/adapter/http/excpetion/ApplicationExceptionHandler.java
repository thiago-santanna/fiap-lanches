package com.tsswebapps.fiaplanches.adapter.http.excpetion;

import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ResponseError> applicationException(ApplicationException ex, WebRequest request) {

        HttpStatus httpStatus = switch (ex.getTipoExcecao().toString()) {
            case "ERRO", "CPF_DEVE_SER_INFORMADO" -> HttpStatus.BAD_REQUEST;
            case "RECURSO_NAO_ENCONTRADO" -> HttpStatus.NOT_FOUND;
            default -> HttpStatus.BAD_REQUEST;
        };

        var response = ResponseError.builder()
                .mensagens(Collections.singletonList(ex.getTipoExcecao().getMessagemError()))
                .erro(ex.getTipoExcecao().toString().toLowerCase())
                .codigo(httpStatus.value())
                .timestamp(new Date())
                .path(request.getDescription(false))
                .build();
        return new ResponseEntity<>(response, httpStatus);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var erros = ex.getFieldErrors().stream()
                .map(item -> item.getField() + " " + item.getDefaultMessage())
                .collect(Collectors.toList());

        var response = ResponseError.builder()
                .mensagens(erros)
                .erro("Erro na validação dos dados de entrada")
                .codigo(HttpStatus.BAD_REQUEST.value())
                .timestamp(new Date())
                .path(request.getDescription(false))
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
