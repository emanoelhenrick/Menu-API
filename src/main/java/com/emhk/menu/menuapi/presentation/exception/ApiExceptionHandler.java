package com.emhk.menu.menuapi.presentation.exception;

import com.emhk.menu.menuapi.domain.exceptions.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest req) {
		var status = HttpStatus.NOT_FOUND;
		var detail = ex.getMessage();
		var problemType = ProblemType.RESOURCE_NOT_FOUND;
		var body = makeProblemBuilder(status, problemType, detail)
			.userMessage(detail)
			.build();
		return handleExceptionInternal(ex, body, new HttpHeaders(), status, req);
	}

	protected ResponseEntity<Object> handleExceptionInternal(
		Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request
	) {
		if (body == null) {
			body = ProblemDetails.builder()
				.status(status.value())
				.title(status.getReasonPhrase())
				.build();
		} else if (body instanceof String) {
			body = ProblemDetails.builder()
				.status(status.value())
				.title((String) body)
				.build();
		}
		return new ResponseEntity<>(body, headers, status);
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
