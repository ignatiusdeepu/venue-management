package com.netinsight.scheduall.venue.management.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.netinsight.scheduall.venue.management.domain.response.BasicErrorResponse;
import com.netinsight.scheduall.venue.management.domain.response.ResultResponse;
import com.netinsight.scheduall.venue.management.domain.response.StandardResponse;

@Component
public class ExceptionManagerImpl implements ExceptionManager
{

	Logger logger = LoggerFactory.getLogger(ExceptionManagerImpl.class);


	@Override
	public StandardResponse<List<BasicErrorResponse>> logAndProduceError(ApplicationException ex)
	{
		return logAndProduceError(ex.getErrorCode(), ex.getMessage(), ex);
	}

	@Override
	public StandardResponse<List<BasicErrorResponse>> logAndProduceError(Throwable t)
	{
		return logAndProduceError(getDefaultErrorCode(), t.getMessage(), t);
	}

	@Override
	public StandardResponse<List<BasicErrorResponse>> logAndProduceError(MethodArgumentNotValidException badRequestData)
	{
		final StandardResponse<List<BasicErrorResponse>> response = new StandardResponse<List<BasicErrorResponse>>();
		final List<BasicErrorResponse> data = new ArrayList<BasicErrorResponse>(10);

		final String systemMessage = buildSystemMessage(badRequestData);

		final List<ObjectError> allErrors = badRequestData.getBindingResult().getAllErrors();

		allErrors.forEach(error -> {
			BasicErrorResponse bindError;
			bindError = new BasicErrorResponse(error.getDefaultMessage(),null);
			data.add(bindError);
		});

		final ResultResponse result = new ResultResponse(systemMessage);
		response.setData(data);
		response.setResult(result);
		return response;
	}


	public StandardResponse<List<BasicErrorResponse>> logAndProduceError(String errorCode, String userMessage, Throwable t)
	{

		final StandardResponse<List<BasicErrorResponse>> response = new StandardResponse<List<BasicErrorResponse>>();
		final String systemMessage = buildSystemMessage(t);
		final ResultResponse result = new ResultResponse(systemMessage);
		result.setInfo("Failed in Request processing");

		final BasicErrorResponse data = new BasicErrorResponse(errorCode, userMessage);
		response.setData(Arrays.asList(data));
		response.setResult(result);

		return response;
	}

	private String buildSystemMessage(Throwable cause)
	{

		logger.error(cause.getMessage(), cause);
		final StringBuilder retVal = new StringBuilder("Unhandled Exception: ");
		retVal.append(cause.getClass().getName());
		retVal.append(":");
		retVal.append(cause.getMessage());
		retVal.append(System.lineSeparator());
		final String stackTrace = StringUtils.join(cause.getStackTrace(), System.lineSeparator());
		retVal.append(stackTrace);
		return retVal.toString();
	}

	@Override
	public String getDefaultErrorCode()
	{
		return DEFAULT_ERROR_CODE;
	}



}
