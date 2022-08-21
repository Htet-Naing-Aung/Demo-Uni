package com.university.crud.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@AllArgsConstructor
public class ApiException {

    @Getter @Setter
    private final String message;

    @Getter @Setter
    private final HttpStatus httpStatus;

    @Getter @Setter
    private final ZonedDateTime timestamp;
}
