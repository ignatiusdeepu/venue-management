package com.netinsight.scheduall.venue.management.domain.response;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "VenueDetails", description = "Contains list of venue details")
public class VenueDetails {

	@ApiModelProperty(notes = "name")
	@JsonProperty("name")
	private String name;
	
	@ApiModelProperty(notes = "description")
	@JsonProperty("description")
	private String description;
	
	@ApiModelProperty(notes = "address")
	@JsonProperty("address")
	private AddressResponse address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AddressResponse getAddress() {
		return address;
	}

	public void setAddress(AddressResponse address) {
		this.address = address;
	}
	
	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
