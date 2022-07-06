package com.tony.service;

import java.util.List;

import com.tony.entity.Country;

public interface CountryService {
	Country saveCountry(Country country);

	List<Country> getAllCountrys();

	String deleteCountry(Integer countryId);

	Country getCountryById(Integer countryId);

	String getCountryByEmployeeName(String employeeName);

	List<String> getAllEmployeesNamesByCountry(String countryName);

	Country updateCountry(Country country);
}
