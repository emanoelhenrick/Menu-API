package com.emhk.menu.menuapi.config.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ReportAsSingleViolation
@Constraint(validatedBy = { FileContentTypeValidator.class })
public @interface FileContentType {

  String message() default "invalid content type";

  Class<?>[] groups() default { };
  Class<? extends Payload>[] payload() default { };
  String[] contentTypes();

}
