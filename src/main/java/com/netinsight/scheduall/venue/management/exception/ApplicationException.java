package com.netinsight.scheduall.venue.management.exception;

public class ApplicationException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	private int httpResponseCd = 400;
	private final String errorCode;

	public ApplicationException(String code)
	{
		this.errorCode = code;
	}

	public ApplicationException(String code, String message)
	{
		super(message);
		this.errorCode = code;
	}

	public ApplicationException(int httpStatus, String code, String message)
	{
		super(message);
		this.httpResponseCd = httpStatus;
		this.errorCode = code;
	}

	public ApplicationException(String code, String message, Throwable cause)
	{
		super(message, cause);
		this.errorCode = code;
	}

	public ApplicationException(int status, String code, String message, Throwable cause)
	{
		super(message, cause);
		this.errorCode = code;
		this.httpResponseCd = status;
	}

	public String getErrorCode()
	{
		return errorCode;
	}

	public int getHttpStatus()
	{
		return httpResponseCd;
	}

}
