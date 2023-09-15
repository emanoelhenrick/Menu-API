package com.emhk.menu.menuapi.presentation.controllers.dtos.productImage.input;

import com.emhk.menu.menuapi.config.validation.FileContentType;
import com.emhk.menu.menuapi.config.validation.FileSize;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

public class productImage {

  @FileSize(max = "1MB")
  @FileContentType(contentTypes = { MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE })
  private MultipartFile image;

}
