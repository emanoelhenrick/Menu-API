package com.emhk.menu.menuapi.domain.services.storage;

import lombok.Builder;
import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public interface ImageStorageService {

  void save(NewImage newImage) throws IOException;
  void remove(String filename);
  InputStream getImage(String filename);

  default void replace(String oldFilename, NewImage newImage) throws IOException {
    save(newImage);
    if (oldFilename != null) remove(oldFilename);
  }

  default String generateFilename(String filename) {
    return UUID.randomUUID().toString() + filename;
  }

  @Builder
  @Getter
  class NewImage {
    private String filename;
    private InputStream inputStream;
  }
}
