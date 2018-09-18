package com.ss.saga.custom.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.ss.saga.employeemanagement.util.ConsoleOutput;
import com.ss.saga.employeemanagement.util.XMLConverter;

/**
 * @author pradeshp
 *
 */
@Configuration
public class CreateRestTemplate {

  @Bean
  public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {

    return restTemplateBuilder.build();
  }

  @Bean
  public ConsoleOutput getConsoleOutput() {

    return new ConsoleOutput();
  }

  @Bean
  public XMLConverter getXMLConverter() {

    return new XMLConverter();
  }
}
