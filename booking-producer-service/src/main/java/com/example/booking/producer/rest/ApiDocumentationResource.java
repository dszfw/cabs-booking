package com.example.booking.producer.rest;

import java.io.IOException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiDocumentationResource {

  private static final String APPLICATION_X_YAML = "application/x-yaml";
  private static final String API_DOCS_YML = "api-docs.yml";

  private final ResourceLoader resourceLoader;

  public ApiDocumentationResource(ResourceLoader resourceLoader) {
    this.resourceLoader = resourceLoader;
  }

  @GetMapping(value = "/" + API_DOCS_YML, produces = APPLICATION_X_YAML)
  public ResponseEntity<?> apiDocs() throws IOException {
    Resource resource = resourceLoader.getResource("classpath:" + API_DOCS_YML);
    if (!resource.exists()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return ResponseEntity
        .ok()
        .contentType(MediaType.parseMediaType(APPLICATION_X_YAML))
        .header("Content-Disposition", "attachment; filename=" + API_DOCS_YML)
        .body(new InputStreamResource(resource.getInputStream()));
  }

}