package com.emhk.menu.menuapi.presentation.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.context.request.WebRequest;

import java.time.OffsetDateTime;

public class ExceptionHandlerHelper {

	public static ResponseEntity<Object> makeResponseEntity(
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

	public static ProblemDetails.ProblemDetailsBuilder makeProblemBuilder(
		HttpStatus status, ProblemType problemType, String detail
	) {
		return ProblemDetails.builder()
			.status(status.value())
			.title(problemType.name())
			.detail(detail)
			.timestamp(OffsetDateTime.now());
	}

}
