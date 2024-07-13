package com.sab.sabglobal.exception;





import com.sab.sabglobal.model.CustomError;
import com.sab.sabglobal.util.GlobalConstant;

import java.util.Collections;

public class NotFoundException extends SABBaseException {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String message) {
		super(Collections.singletonList(new CustomError(GlobalConstant.NOT_FOUND_ERROR_CODE, message,
				GlobalConstant.NOT_FOUND_ERROR_TYPE)));
	}
}
