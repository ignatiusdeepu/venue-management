package com.netinsight.scheduall.venue.management.domain.response;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "EventGroup", description = "Contains the event group details")
public class EventGroup {

	@ApiModelProperty(notes = "id")
	@JsonProperty("id")
	private Long id;
	
	@ApiModelProperty(notes = "Group Name")
	@JsonProperty("name")
	private String name;
	
	@ApiModelProperty(notes = "Group Description")
	@JsonProperty("description")
	private String description;
	
	@ApiModelProperty(notes = "Group StartDate")
	@JsonProperty("startDate")
	private Date startDate;
	
	@ApiModelProperty(notes = "Group EndDate")
	@JsonProperty("endDate")
	private Date endDate;
	
	@ApiModelProperty(notes = "Group Client")
	@JsonProperty("client")
	private String client;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
