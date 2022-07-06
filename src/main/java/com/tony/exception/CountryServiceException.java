package com.tony.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CountryServiceException extends Exception {
	private String errorMessage;

}
