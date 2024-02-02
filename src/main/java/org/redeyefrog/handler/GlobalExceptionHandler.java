package org.redeyefrog.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.redeyefrog.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ObjectNode onMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return response(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public ObjectNode onBindException(BindException e) {
        String message = String.join(",", e.getAllErrors()
                                           .stream()
                                           .map(ObjectError::getDefaultMessage)
                                           .collect(Collectors.toList()));
        return response(message);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ObjectNode onException(Exception e) {
        log.error(e.getMessage(), e);
        return response(StatusCode.SYSTEM_ERROR.getDesc());
    }

    private ObjectNode response(String message) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("error_message", message);
        return objectNode;
    }

}
