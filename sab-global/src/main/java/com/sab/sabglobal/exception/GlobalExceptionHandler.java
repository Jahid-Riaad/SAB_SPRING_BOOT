package com.sab.sabglobal.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.sab.sabglobal.model.CustomError;
import com.sab.sabglobal.model.CustomPayload;
import com.sab.sabglobal.model.CustomResponse;
import com.sab.sabglobal.util.ResponseBuilder;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import static com.sab.sabglobal.util.GlobalConstant.*;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private ResponseBuilder<CustomPayload> responseBuilder;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		this.logger.info("GlobalExceptionHandler Exception request :" + request);
		this.logger.error("Error Track is:::-------", ex);

		FieldError fieldError = ex.getBindingResult().getFieldError();
		logger.error("[handleMethodArgumentNotValid]-field={}, rejectedValue={}, defaultMessage={}",
				fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage());

		CustomError error = new CustomError();
		if (ObjectUtils.isEmpty(fieldError.getRejectedValue())) {
			error.setCode(MANDATORY_FIELD_WARNING_CODE)
					.setMessage(String.format("%s : %s",fieldError.getField(), fieldError.getDefaultMessage()))
					.setType(MANDATORY_FIELD_WARNING_TYPE);
		} else {
			error.setCode(FORMAT_ERROR_WARNING_CODE)
					.setMessage(String.format("%s : %s",fieldError.getField(), fieldError.getDefaultMessage()))
					.setType(FORMAT_ERROR_WARNING_TYPE);
		}
		List<CustomError> errors = new ArrayList<>();
		errors.add(error);
		this.logger.error(ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(this.responseBuilder.buildResponse(Collections.emptyList(), errors, false));
	}

	@ExceptionHandler({ SQLException.class, DataIntegrityViolationException.class })
	public ResponseEntity<CustomResponse<CustomPayload>> handleSQLException(HttpServletRequest request, Exception ex) {
		this.logger.info("GlobalExceptionHandler HttpServletRequest request :" + request);
		this.logger.error("Error Track is:::-------", ex);

		CustomError error = new CustomError();
		error.setCode(SOMETHING_WRONG_ERROR_CODE).setMessage(SOMETHING_WRONG_ERROR_MESSAGE)
				.setType(SOMETHING_WRONG_ERROR_TYPE);

		List<CustomError> errors = new ArrayList<>();
		errors.add(error);

		this.logger.error("There was an Error trying to read/write to the database:: SQL Exception");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(this.responseBuilder.buildResponse(Collections.emptyList(), errors, false));
	}

	@ExceptionHandler({InvalidFormatException.class})
	public ResponseEntity<CustomResponse<CustomPayload>> handleInvalidFormatException(HttpServletRequest request, InvalidFormatException ex) {
		this.logger.info("GlobalExceptionHandler HttpServletRequest request :" + request);
		this.logger.error("Error Track is:::-------", ex);

		CustomError error = new CustomError();
		error.setCode(FORMAT_ERROR_WARNING_CODE).setMessage(FORMAT_ERROR_WARNING_MESSAGE)
				.setType(FORMAT_ERROR_WARNING_TYPE);

		List<CustomError> errors = new ArrayList<>();
		errors.add(error);

		this.logger.error("There was an Error in the format of the value provided");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(this.responseBuilder.buildResponse(Collections.emptyList(), errors,  false));
	}

	@ExceptionHandler({ EmptyResultDataAccessException.class, NoSuchElementException.class,
			NullPointerException.class })
	public ResponseEntity<CustomResponse<CustomPayload>> handleEmptyResultException(HttpServletRequest request,
			Exception ex) {
		this.logger.info("GlobalExceptionHandler HttpServletRequest request :" + request);
		this.logger.error("Error Track is:::-------", ex);

		CustomError error = new CustomError();
		error.setCode(SOMETHING_WRONG_ERROR_CODE).setMessage(SOMETHING_WRONG_ERROR_MESSAGE)
				.setType(SOMETHING_WRONG_ERROR_TYPE);
		List<CustomError> errors = new ArrayList<>();
		errors.add(error);

		this.logger.error("There was an Error trying to retrieve the data");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(this.responseBuilder.buildResponse(Collections.emptyList(), errors,  false));
	}

	@ExceptionHandler({ SABBaseException.class })
	public ResponseEntity<CustomResponse<CustomPayload>> handleCustomException(HttpServletRequest request,
			SABBaseException ex) {
		this.logger.info("GlobalExceptionHandler HttpServletRequest request :" + request);
		this.logger.error("Error Track is:::-------", ex);


		this.logger.error("There was an Error trying to retrieve the data");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				this.responseBuilder.buildResponse(Collections.emptyList(), ex.getErrors(),false));
	}

	@ExceptionHandler({ Exception.class, RuntimeException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<CustomResponse<CustomPayload>> handleCustomException(HttpServletRequest request,
			Exception ex) {
		this.logger.info("GlobalExceptionHandler Exception request :" + request);
		this.logger.error("Error Track is:::-------", ex);

		CustomError error = new CustomError();
		error.setCode(SOMETHING_WRONG_ERROR_CODE).setMessage(SOMETHING_WRONG_ERROR_MESSAGE)
				.setType(SOMETHING_WRONG_ERROR_TYPE);
		List<CustomError> errors = new ArrayList<>();
		errors.add(error);
		this.logger.error(ex.getMessage());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(this.responseBuilder.buildResponse(Collections.emptyList(), errors, false));
	}
	@ExceptionHandler({GlobalException.class})
	public ResponseEntity<CustomResponse<CustomPayload>> handleConstraintViolationException(HttpServletRequest request, GlobalException ex) {
		this.logger.info("GlobalExceptionHandler HttpServletRequest request :" + request);
		this.logger.error("Error Track is:::-------", ex);

		List<CustomError> errors = ex.getErrors();
		if(errors == null || errors.size() < 1){
			CustomError error = new CustomError();
			error.setCode(INVALID_FIELD_MANDATORY_ERROR_CODE).setMessage(ex.getMessage())
					.setType(INVALID_FIELD_MANDATORY_ERROR_TYPE);
			errors = new ArrayList<>();
			errors.add(error);
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(this.responseBuilder.buildResponse(Collections.emptyList(), errors,  false));
	}
	@ExceptionHandler({ConstraintViolationException.class})
	public ResponseEntity<CustomResponse<CustomPayload>> handleConstraintViolationException(HttpServletRequest request, ConstraintViolationException ex) {
		this.logger.info("GlobalExceptionHandler HttpServletRequest request :" + request);
		this.logger.error("Error Track is:::-------", ex);

		CustomError error = new CustomError();
		error.setCode(FORMAT_ERROR_WARNING_CODE).setMessage(ex.getMessage())
				.setType(FORMAT_ERROR_WARNING_TYPE);
		List<CustomError> errors = new ArrayList<>();
		errors.add(error);
		this.logger.error(ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(this.responseBuilder.buildResponse(Collections.emptyList(), errors, false));
	}
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
																  HttpHeaders headers, HttpStatus status,
																  WebRequest request) {

		this.logger.info("GlobalExceptionHandler Exception request: " + request);
		this.logger.error("Error HttpMessageNotReadableException Track: ", ex);

		String conciseErrorMessage = "Invalid data received. ";

		// Extract field name from the exception message, assuming the message format contains field information
		String errorMessage = ex.getMessage();
		String fieldName = null;

		if (errorMessage != null) {
			int fieldNameStartIndex = errorMessage.indexOf("[\"");
			int fieldNameEndIndex = errorMessage.indexOf("\"]", fieldNameStartIndex + 1);

			if (fieldNameStartIndex != -1 && fieldNameEndIndex != -1) {
				fieldName = errorMessage.substring(fieldNameStartIndex + 2, fieldNameEndIndex);
			}
		}

		if (fieldName != null) {
			conciseErrorMessage += "Invalid data in field: " + fieldName + ". Please check and correct the field value.";
		} else {
			conciseErrorMessage += "Please check the request body and ensure it is formatted correctly.";
		}

		CustomError error = new CustomError();
		error.setCode(FORMAT_ERROR_WARNING_CODE)
				.setMessage(conciseErrorMessage)
				.setType(FORMAT_ERROR_WARNING_TYPE);

		List<CustomError> errors = Collections.singletonList(error);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(this.responseBuilder.buildResponse(Collections.emptyList(), errors, false));
	}
	@ExceptionHandler({JsonMappingException.class})
	public ResponseEntity<CustomResponse<CustomPayload>> handleJsonMappingException(HttpServletRequest request, JsonMappingException ex) {
		this.logger.info("Json Mapping Exception request :" + request);
		this.logger.error("Error Track is:::-------", ex);

		CustomError error = new CustomError();
		error.setCode(FORMAT_ERROR_WARNING_CODE).setMessage(ex.getMessage())
				.setType(FORMAT_ERROR_WARNING_TYPE);
		List<CustomError> errors = new ArrayList<>();
		errors.add(error);
		this.logger.error(ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(this.responseBuilder.buildResponse(Collections.emptyList(), errors, false));
	}

}