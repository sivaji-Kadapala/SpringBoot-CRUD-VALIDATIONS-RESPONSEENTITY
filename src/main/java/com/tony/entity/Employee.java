package com.tony.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;
	@NotNull(message = "employeeName should not be null")
	@NotEmpty(message = "employeeName should not be empty")
	@Size(min = 3, max = 15, message = "empName should  be min 3 & max 20 char")
	private String employeeName;
	@Min(value = 5000, message = "employeeSalary should be min 5000")
	@Max(value = 10000, message = "employeeSalary should be max 10000")
	@NotNull(message = "employeeSalary should not be null")
	private String employeeSalary;

}
