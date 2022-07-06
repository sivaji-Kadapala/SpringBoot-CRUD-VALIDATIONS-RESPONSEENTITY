package com.tony.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.entity.Country;
import com.tony.entity.Employee;
import com.tony.exception.CountryServiceException;

import com.tony.service.CountryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/country-services")
@AllArgsConstructor
public class CountryController {

	@Autowired
	private CountryService countryService;

	@PostMapping
	// http://localhost:8080/myapp/country-services
	public ResponseEntity<Country> saveCountry(@Valid @RequestBody Country country) throws CountryServiceException {
		return Optional.ofNullable(country).map(countryService::saveCountry).filter(Objects::nonNull)
				.map(r -> new ResponseEntity<>(r, HttpStatus.CREATED)).orElseThrow(() -> new CountryServiceException(
						"Country is not saved due to some error,please try after some time"));
	}

	@GetMapping
	// http://localhost:8080/myapp/country-services
	public ResponseEntity<List<Country>> getAllCountry() {
		return Optional.ofNullable(countryService.getAllCountrys())

				.map(r -> new ResponseEntity<>(r, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.OK));
	}

	@DeleteMapping("{countryId}")
	// http://localhost:8080/myapp/country-services/id
	public ResponseEntity<String> deleteCountry(@NotNull @PathVariable("countryId") Integer countryId) {
		return Optional.ofNullable(countryId).map(r -> countryService.deleteCountry(r)).filter(Objects::nonNull)
				.map(r -> new ResponseEntity<>(r, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>("country Id is not deleted due to some error,Please try later ",
						HttpStatus.BAD_REQUEST));
	}

	@GetMapping("{countryId}")
	// http://localhost:8080/myapp/country-services
	public ResponseEntity<Country> getCountryById(@NotNull @PathVariable("countryId") Integer countryId) {
		return Optional.ofNullable(countryId).map(r -> countryService.getCountryById(r)).filter(Objects::nonNull)
				.map(r -> new ResponseEntity<>(r, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
	}

	@GetMapping("/country-by-employee-name")
	// http://localhost:8080/myapp/country-services/country-by-employee-name?employeeName=Sivaji
	public ResponseEntity<String> getCountryByEmployeeName(
			@NotNull @NotEmpty @RequestParam("employeeName") String employeeName) {
		return Optional.ofNullable(employeeName).filter(r -> r != null && r.length() > 2)
				.map(r -> countryService.getCountryByEmployeeName(r)).filter(Objects::nonNull)
				.map(r -> new ResponseEntity<>(r, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
	}

	@GetMapping("/all-employee-names-by-country/{countryName}")
	// http://localhost:8080/myapp/country-services/countryName
	public ResponseEntity<List<String>> getAllEmployeesByCountry(
			@NotNull @NotEmpty @PathVariable("countryName") String countryName) {
		return Optional.ofNullable(countryName).filter(r -> r != null && r.length() > 2)
				.map(r -> countryService.getAllEmployeesNamesByCountry(r)).filter(Objects::nonNull)
				.map(r -> new ResponseEntity<>(r, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));

	}

	@PutMapping
	// http://localhost:8080/myapp/country-services
	public ResponseEntity<Country> updateCountry(@Valid @RequestBody Country country) throws CountryServiceException {
		return Optional.ofNullable(country).map(countryService::updateCountry).filter(Objects::nonNull)
				.map(r -> new ResponseEntity<>(r, HttpStatus.CREATED)).orElseThrow(() -> new CountryServiceException(
						"Country is not saved due to some error,please try after some time"));
	}

}
