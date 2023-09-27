package com.emhk.menu.menuapi.infra.service.storage;

import com.emhk.menu.menuapi.domain.exceptions.BusinessException;
import com.emhk.menu.menuapi.domain.services.storage.ImageStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class LocalImageStoreService implements ImageStorageService {

  @Value("${menu.storage.local.image-dir}")
  private Path outputPath;

  @Override
  public void save(NewImage newImage) throws IOException {
    FileCopyUtils.copy(
      newImage.getInputStream(),
      Files.newOutputStream(getFilePath(newImage.getFilename()))
    );
  }

  @Override
  public void remove(String filename) {
    try {
      Files.deleteIfExists(getFilePath(filename));
    } catch (Exception ex) {
      throw new BusinessException(ex.getMessage());
    }
  }

  @Override
  public InputStream getImage(String filename) {
    try {
      var fileExists = Files.exists(getFilePath(filename));
      if (!fileExists) throw new BusinessException("temp file not found");
      return Files.newInputStream(getFilePath(filename));
    } catch (Exception ex) {
      throw  new BusinessException(ex.getMessage());
    }

  }

  private Path getFilePath(String filename) {
    return outputPath.resolve(Path.of(filename));
  }

}
