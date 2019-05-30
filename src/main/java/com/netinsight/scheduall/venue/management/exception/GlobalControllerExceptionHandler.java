package com.netinsight.scheduall.venue.management.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.netinsight.scheduall.venue.management.domain.response.BasicResponse;
import com.netinsight.scheduall.venue.management.domain.response.StandardResponse;


@ControllerAdvice
public class GlobalControllerExceptionHandler
{

	@Autowired
	ExceptionManager exceptionManager;

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler({ RuntimeException.class, Exception.class })
	public @ResponseBody BasicResponse logAndProduceBadRequestError(Exception e)
	{

		final BasicResponse errorResponse = exceptionManager.logAndProduceError(e);
		return errorResponse;
	}

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public @ResponseBody BasicResponse handleBindErrors(MethodArgumentNotValidException badRequestData)
	{
		return exceptionManager.logAndProduceError(badRequestData);
	}


	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler({ ApplicationException.class })
	public @ResponseBody StandardResponse<?> logAndProduceInternalServerError(ApplicationException e)
	{
		return exceptionManager.logAndProduceError(e);
	}


}