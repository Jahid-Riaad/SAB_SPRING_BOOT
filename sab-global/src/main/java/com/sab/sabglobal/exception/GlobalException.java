package com.sab.sabglobal.exception;

import com.sab.sabglobal.model.CustomError;

import java.util.List;

public class GlobalException extends SABBaseException {

	private static final long serialVersionUID = 619665828707923005L;

	public GlobalException() {
		super();
	}

	public GlobalException(List<CustomError> error) {
		super(error);
	}

	public GlobalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GlobalException(String message, Throwable cause) {
		super(message, cause);
	}

	public GlobalException(String message) {
		super(message);
	}

	public GlobalException(Throwable cause) {
		super(cause);
	}
}