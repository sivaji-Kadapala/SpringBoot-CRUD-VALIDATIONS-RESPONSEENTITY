package com.tony.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tony.entity.Country;
import com.tony.entity.Employee;
import com.tony.repository.CountryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {
	private CountryRepository countryRepository;

	@Override
	public Country saveCountry(Country country) {
		// TODO Auto-generated method stub
		return countryRepository.save(country);
	}

	@Override
	public List<Country> getAllCountrys() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}

	@Override
	public String deleteCountry(Integer countryId) {
		String message = null;
		try {
			// TODO Auto-generated method stub
			countryRepository.deleteById(countryId);
			message = "Country deleted successfully";
		} catch (Exception e) {
			// TODO: handle exception
			message = countryId + " CountryId not found";
		}
		return message;
	}

	@Override
	public Country getCountryById(Integer countryId) {
		// TODO Auto-generated method stub
		return countryRepository.findById(countryId).get();
	}

	@Override
	public String getCountryByEmployeeName(String employeeName) {
		// TODO Auto-generated method stub
		Country country = countryRepository.findByCompaniesEmployeesEmployeeName(employeeName);
		return country.getCountryName();
	}

	@Override
	public List<String> getAllEmployeesNamesByCountry(String countryName) {
		// TODO Auto-generated method stub
		List<String> allEmployeeNames = new ArrayList<>();
		Country country = countryRepository.findByCountryName(countryName);
		country.getCompanies().stream().forEach(r -> {
			allEmployeeNames
					.addAll(r.getEmployees().stream().map(Employee::getEmployeeName).collect(Collectors.toList()));
		});
		return allEmployeeNames;
	}

	@Override
	public Country updateCountry(Country country) {
		// TODO Auto-generated method stub
		return countryRepository.save(country);
	}

}
