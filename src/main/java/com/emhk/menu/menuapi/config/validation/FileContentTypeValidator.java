package com.emhk.menu.menuapi.config.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

public class FileContentTypeValidator implements ConstraintValidator<FileContentType, MultipartFile> {

  private List<MediaType> mediaType;

  @Override
  public void initialize(FileContentType constraintAnnotation) {
    List<String> mediaTypesString = Arrays.stream(constraintAnnotation.contentTypes()).toList();
    this.mediaType = MediaType.parseMediaTypes(mediaTypesString);
  }

  @Override
  public boolean isValid(MultipartFile value, ConstraintValidatorContext constraintValidatorContext) {
    if (value.getContentType() == null) return false;
    var contentType = MediaType.parseMediaType(value.getContentType());
    return mediaType.contains(contentType);
  }
}
