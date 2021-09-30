package com.example.booking.database.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("booking.database.server")
public class DbServerProperties {

  private String port;

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

}
