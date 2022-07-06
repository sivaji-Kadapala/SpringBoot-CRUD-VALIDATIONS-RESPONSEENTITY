package com.tony.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer countryId;
	@NotNull(message = "countryName should not be null")
	@NotEmpty(message = "countryName should not be empty")
	@Size(min = 3, max = 20, message = "countryName should  be min 3 & max 20 char")
	private String countryName;
	@NotNull(message = "countryCode should not be null")
	@NotEmpty(message = "countryCode should not be empty")
	@Size(min = 3, max = 3)
	private String countryCode;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "country_fk", referencedColumnName = "countryId")
	private List<Company> companies;

}
