package com.emhk.menu.menuapi.presentation.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
		Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request
	) {
		if (body == null) {
			body = ProblemDetails.builder()
				.status(statusCode.value())
				.title(ex.getMessage())
				.build();
		} else if (body instanceof String) {
			body = ProblemDetails.builder()
				.status(statusCode.value())
				.title((String) body)
				.build();
		}
		return new ResponseEntity<>(body, headers, statusCode);
	}

	private ProblemDetails.ProblemDetailsBuilder makeProblemBuilder(
		HttpStatus status, ProblemType problemType, String detail
	) {
		return ProblemDetails.builder()
			.status(status.value())
			.title(problemType.name())
			.detail(detail)
			.timestamp(OffsetDateTime.now());
	}
}
