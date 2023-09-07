package com.json.schema.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Valid
public class Address {

	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	@NotBlank(message = "City is mandatory field and should not be null")
	private String city;
	@NotBlank(message = "State is mandatory field and should not be null")
	private String state;
	@NotBlank(message = "Pincode is mandatory field and should not be null")
	private String pincode;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Address() {

	}

	public Address(String addressLine1, String addressLine2, String addressLine3, String city, String state,
			String pincode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

}
