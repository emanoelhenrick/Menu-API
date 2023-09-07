package com.emhk.menu.menuapi.presentation.exception;

import com.emhk.menu.menuapi.domain.exceptions.BusinessException;
import com.emhk.menu.menuapi.domain.exceptions.EntityNotAvailable;
import com.emhk.menu.menuapi.domain.exceptions.EntityNotFoundException;
import com.emhk.menu.menuapi.domain.exceptions.InUseEntityException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import static com.emhk.menu.menuapi.presentation.exception.ExceptionHandlerHelper.*;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BusinessExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest req) {
		var status = HttpStatus.NOT_FOUND;
		var detail = ex.getMessage();
		var problemType = ProblemType.RESOURCE_NOT_FOUND;
		var body = makeProblemBuilder(status, problemType, detail)
			.userMessage(detail)
			.build();
		return makeResponseEntity(ex, body, new HttpHeaders(), status, req);
	}

	@ExceptionHandler(EntityNotAvailable.class)
	public ResponseEntity<?> handleEntityNotAvailable(EntityNotAvailable ex, WebRequest req) {
		var status = HttpStatus.FORBIDDEN;
		var detail = ex.getMessage();
		var problemType = ProblemType.ENTITY_NOT_AVAILABLE;
		var body = makeProblemBuilder(status, problemType, detail)
			.userMessage(detail)
			.build();
		return makeResponseEntity(ex, body, new HttpHeaders(), status, req);
	}

	@ExceptionHandler(InUseEntityException.class)
	public ResponseEntity<?> handleInUseEntityException(InUseEntityException ex, WebRequest req) {
		var status = HttpStatus.CONFLICT;
		var detail = ex.getMessage();
		var problemType = ProblemType.IN_USE_ENTITY;
		var body = makeProblemBuilder(status, problemType, detail)
			.userMessage(detail)
			.build();
		return makeResponseEntity(ex, body, new HttpHeaders(), status, req);
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> handleBusinessException(BusinessException ex, WebRequest req) {
		var status = HttpStatus.BAD_REQUEST;
		var detail = ex.getMessage();
		var problemType = ProblemType.BAD_REQUEST;
		var body = makeProblemBuilder(status, problemType, detail)
			.userMessage(detail)
			.build();
		return makeResponseEntity(ex, body, new HttpHeaders(), status, req);
	}

}
