package com.example.booking.dao;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.example.booking.dao.repo")
@EntityScan("com.example.booking.domain")
@EnableTransactionManagement
public class DaoConfig {

}
