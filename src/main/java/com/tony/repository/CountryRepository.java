package com.tony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tony.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
	Country findByCompaniesEmployeesEmployeeName(String employeeName);

	Country findByCountryName(String countryName);
}
