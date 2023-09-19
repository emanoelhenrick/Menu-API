package com.emhk.menu.menuapi.domain.services.storage;

import lombok.Builder;
import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public interface SaveImageToStorage {
  void save(NewImage newImage) throws IOException;

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
