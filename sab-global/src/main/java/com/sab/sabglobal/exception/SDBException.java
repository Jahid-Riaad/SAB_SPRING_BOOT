package com.sab.sabglobal.exception;


import com.sab.sabglobal.model.CustomError;

import java.util.List;

public class SDBException extends SABBaseException {

	private static final long serialVersionUID = 619665828707923005L;

	public SDBException() {
		super();
	}

	public SDBException(List<CustomError> error) {
		super(error);
	}

	public SDBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SDBException(String message, Throwable cause) {
		super(message, cause);
	}

	public SDBException(String message) {
		super(message);
	}

	public SDBException(Throwable cause) {
		super(cause);
	}
}