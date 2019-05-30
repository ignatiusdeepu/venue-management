package com.netinsight.scheduall.venue.management.domain.response;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "info", "systemMessage" })
@JsonInclude(value = Include.NON_NULL)
public class ResultResponse implements Serializable
{

	private static final long serialVersionUID = 1L;

	private String systemMessage;

	private String info;

	/** Default Constructor */
	public ResultResponse()
	{
		super();
	}

	public ResultResponse(String systemMessage)
	{
		this.systemMessage = systemMessage;
	}

	/**
	 * @return the system error message (stack trace, exception message, etc)
	 */
	public final String getSystemMessage()
	{
		return systemMessage;
	}

	/**
	 * @param systemMessage
	 *            the info to set
	 */
	public final void setSystemMessage(String systemMessage)
	{
		this.systemMessage = systemMessage;
	}

	public String getInfo()
	{
		return info;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}

	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
