package com.emhk.menu.menuapi.domain.services.storage;

import lombok.Builder;
import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;

public interface SaveImageToStorage {
  void save(NewImage newImage) throws IOException;

  @Builder
  @Getter
  class NewImage {
    private String filename;
    private InputStream inputStream;
  }
}
