package com.emhk.menu.menuapi.presentation.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.emhk.menu.menuapi.presentation.exception.ExceptionHandlerHelper.*;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleInternalServerError(Exception ex, WebRequest req) {
		var status = HttpStatus.INTERNAL_SERVER_ERROR;
		var detail = ex.getMessage();
		var problemType = ProblemType.INTERNAL_SERVER_ERROR;
		var body = makeProblemBuilder(status, problemType, detail)
			.userMessage("An unexpected system error occurred, please try again and if the problem persists, contact support.")
			.build();
		return makeResponseEntity(ex, body, new HttpHeaders(), status, req);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
		Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest req
	) {
		var status = HttpStatus.resolve(statusCode.value());
		return makeResponseEntity(ex, body, headers, status, req);
	}
}
