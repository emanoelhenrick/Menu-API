package com.emhk.menu.menuapi.presentation.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

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
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
		MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request
	) {
    var status = HttpStatus.resolve(statusCode.value());
		var problemType = ProblemType.INVALID_DATA;
		var detail = "One or more fields are invalid. Fill in correctly and try again.";

		List<ProblemDetails.Field> fields = ex.getBindingResult()
			.getFieldErrors().stream()
			.map(fieldError -> {
				return ProblemDetails.Field.builder()
					.name(fieldError.getField())
					.userMessage(fieldError.getDefaultMessage())
					.build();
			}).toList();

    var body = makeProblemBuilder(status, problemType, detail)
      .userMessage(detail)
      .fields(fields)
      .build();

		return handleExceptionInternal(ex, body, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
		Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest req
	) {
		var status = HttpStatus.resolve(statusCode.value());
		return makeResponseEntity(ex, body, headers, status, req);
	}
}
