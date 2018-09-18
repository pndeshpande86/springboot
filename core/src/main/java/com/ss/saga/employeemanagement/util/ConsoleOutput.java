package com.ss.saga.employeemanagement.util;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author pradeshp
 *
 */
@Configuration
public class ConsoleOutput implements CommandLineRunner {

  @Autowired
  RestTemplate restTemplate;

  @Inject
  XMLConverter xmlConverter;

  @Override
  public void run(String... args) throws Exception {

    /*
     * File xmlFile = new File("D:\\dvn\\Devon-dist_2.4.0\\XmlObjs\\entityxml.xml"); if (!xmlFile.exists()) {
     * xmlFile.createNewFile(); } EmployeeEto employeeEto = this.restTemplate
     * .getForObject("http://localhost:8081/services/rest/employeemanagement/v1/employee/1", EmployeeEto.class);
     * 
     * System.out.println("Testing Object to xml functionality... ");
     * 
     * this.xmlConverter.converObJectToXml(employeeEto, xmlFile.getAbsolutePath());
     */
  }

}
