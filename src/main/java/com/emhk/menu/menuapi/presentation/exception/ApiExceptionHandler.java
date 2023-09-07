package com.emhk.menu.menuapi.presentation.exception;

import com.emhk.menu.menuapi.domain.exceptions.EntityNotAvailable;
import com.emhk.menu.menuapi.domain.exceptions.EntityNotFoundException;
import com.emhk.menu.menuapi.domain.exceptions.InUseEntityException;
import jakarta.validation.constraints.NotNull;
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

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest req) {
		var status = HttpStatus.NOT_FOUND;
		var detail = ex.getMessage();
		var problemType = ProblemType.RESOURCE_NOT_FOUND;
		var body = makeProblemBuilder(status, problemType, detail)
			.userMessage(detail)
			.build();
		return handleExceptionInternal(ex, body, new HttpHeaders(), status, req);
	}

	@ExceptionHandler(EntityNotAvailable.class)
	public ResponseEntity<?> handleEntityNotAvailable(EntityNotAvailable ex, WebRequest req) {
		var status = HttpStatus.FORBIDDEN;
		var detail = ex.getMessage();
		var problemType = ProblemType.ENTITY_NOT_AVAILABLE;
		var body = makeProblemBuilder(status, problemType, detail)
			.userMessage(detail)
			.build();
		return handleExceptionInternal(ex, body, new HttpHeaders(), status, req);
	}

	@ExceptionHandler(InUseEntityException.class)
	public ResponseEntity<?> handleInUseEntityException(InUseEntityException ex, WebRequest req) {
		var status = HttpStatus.CONFLICT;
		var detail = ex.getMessage();
		var problemType = ProblemType.IN_USE_ENTITY;
		var body = makeProblemBuilder(status, problemType, detail)
			.userMessage(detail)
			.build();
		return handleExceptionInternal(ex, body, new HttpHeaders(), status, req);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleExceptions(Exception ex, WebRequest req) {
		var status = HttpStatus.INTERNAL_SERVER_ERROR;
		var detail = ex.getMessage();
		var problemType = ProblemType.INTERNAL_SERVER_ERROR;
		var body = makeProblemBuilder(status, problemType, detail)
			.userMessage("An unexpected system error occurred, please try again and if the problem persists, contact support.")
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
