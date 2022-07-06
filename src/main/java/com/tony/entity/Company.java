package com.tony.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tony.enums.CompanyType;

import lombok.Data;

@Data
@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer companyId;
	@NotNull(message = "companyName should not be null")
	@NotEmpty(message = "companyName should not be empty")
	@Size(min = 3, max = 20, message = "companyName should  be min 3 & max 20 char")
	private String companyName;
	@Enumerated(EnumType.STRING)
	private CompanyType companyType;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "company_fk", referencedColumnName = "companyId")
	private List<Employee> employees;

}
