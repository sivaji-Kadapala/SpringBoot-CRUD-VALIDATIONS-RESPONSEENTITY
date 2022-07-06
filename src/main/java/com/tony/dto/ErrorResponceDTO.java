package com.tony.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponceDTO {
	private List<String> errors;
	private Integer statusCode;

}
