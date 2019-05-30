package com.netinsight.scheduall.venue.management.domain.response;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Address", description = "Contains address information of the entity")
public class AddressResponse {

	@ApiModelProperty(notes = "addressLine1")
	@JsonProperty("addressLine1")
	private String addressLine1;
	
	@ApiModelProperty(notes = "addressLine2")
	@JsonProperty("addressLine2")
	private String addressLine2;
	
	@ApiModelProperty(notes = "city")
	@JsonProperty("city")
	private String city;
	
	@ApiModelProperty(notes = "state")
	@JsonProperty("state")
	private String state;
	
	@ApiModelProperty(notes = "country")
	@JsonProperty("country")
	private String country;
	
	@ApiModelProperty(notes = "zipCode")
	@JsonProperty("zipCode")
	private String zipCode;

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
