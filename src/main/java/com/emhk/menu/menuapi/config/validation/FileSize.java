package com.emhk.menu.menuapi.config.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ReportAsSingleViolation
@Constraint(validatedBy = { FileSizeValidator.class })
public @interface FileSize {

  String message() default "invalid file size";

  Class<?>[] groups() default { };
  Class<? extends Payload>[] payload() default { };
  String max();

}
