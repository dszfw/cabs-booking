package com.example.booking.database.conf;

import java.sql.SQLException;
import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbServerConfig {

  private final DbServerProperties serverProperties;

  public DbServerConfig(DbServerProperties serverProperties) {
    this.serverProperties = serverProperties;
  }

  @Bean(initMethod = "start", destroyMethod = "stop")
  public Server inMemoryH2DatabaseServer() throws SQLException {
    return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort",
        serverProperties.getPort());
  }

}
