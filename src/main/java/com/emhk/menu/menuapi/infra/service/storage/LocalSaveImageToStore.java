package com.emhk.menu.menuapi.infra.service.storage;

import com.emhk.menu.menuapi.domain.services.storage.SaveImageToStorage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class LocalSaveImageToStore implements SaveImageToStorage {

  @Value("${menu.storage.local.image-dir}")
  private Path outputPath;

  @Override
  public void save(NewImage newImage) throws IOException {
    FileCopyUtils.copy(
      newImage.getInputStream(),
      Files.newOutputStream(getFilePath(newImage.getFilename()))
    );
  }

  private Path getFilePath(String filename) {
    return outputPath.resolve(Path.of(filename));
  }
}
