package com.pmtech.doctorcrudservice.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "addresses")
public class Address {

	@NotEmpty(message = "Please enter a valid street address")
	@Size(max = 80, message = "Street address cannot exceed 80 characters")
	private String street1;

	@Size(max = 80, message = "Street address cannot exceed 80 characters")
	private String street2;

	@NotEmpty(message = "Please enter a valid city")
	@Size(max = 50, message = "City name cannot exceed 50 characters")
	private String city;

	@NotEmpty(message = "Please enter a valid district")
	@Size(max = 50, message = "District name cannot exceed 50 characters")
	private String district;

	@NotEmpty(message = "Please select a state")
	@Size(max = 2, message = "State must be a two-letter abbreviation")
	private String state;

	private String pinCode;

	@Size(max = 2, message = "Country must be a 2-letter abbreviation")
	private String country;

	private AddressType addressType;

	private List<Location> locations;

}