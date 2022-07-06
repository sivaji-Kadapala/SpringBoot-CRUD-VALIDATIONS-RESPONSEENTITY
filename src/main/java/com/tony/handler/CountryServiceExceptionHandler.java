package com.tony.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tony.dto.ErrorResponceDTO;
import com.tony.exception.CountryServiceException;

@ControllerAdvice
public class CountryServiceExceptionHandler {
	@ExceptionHandler(value = CountryServiceException.class)
	public ResponseEntity<Object> handleCountryServiceException(CountryServiceException ex) {
		ErrorResponceDTO errorResponceDTO = new ErrorResponceDTO(Arrays.asList(ex.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR.value());

		return new ResponseEntity<>(errorResponceDTO, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
		List<String> errors = new ArrayList<String>();
		ex.getConstraintViolations().stream().forEach(res -> {
			errors.add(res.getMessage());
		});
		ErrorResponceDTO errorResponceDTO = new ErrorResponceDTO(errors, HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(errorResponceDTO, HttpStatus.BAD_REQUEST);
	}

}
