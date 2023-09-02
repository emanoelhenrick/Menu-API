package com.emhk.menu.menuapi.presentation.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
public class ProblemDetails {

  private Integer status;
  private String type;
  private String title;
  private String detail;
  private String userMessage;
  private OffsetDateTime timestamp;
  private List<Field> fields;

  @Getter
  @Builder
  public static class Field {
    private String name;
    private String userMessage;
  }

}
