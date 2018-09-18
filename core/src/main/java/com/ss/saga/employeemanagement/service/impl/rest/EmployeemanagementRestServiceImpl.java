package com.ss.saga.employeemanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import com.ss.saga.employeemanagement.logic.api.Employeemanagement;
import com.ss.saga.employeemanagement.logic.api.to.EmployeeCto;
import com.ss.saga.employeemanagement.logic.api.to.EmployeeEto;
import com.ss.saga.employeemanagement.logic.api.to.EmployeeSearchCriteriaTo;
import com.ss.saga.employeemanagement.service.api.rest.EmployeemanagementRestService;
import com.ss.saga.employeemanagement.util.ConsoleOutput;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Employeemanagement}.
 */
@Named("EmployeemanagementRestService")
public class EmployeemanagementRestServiceImpl implements EmployeemanagementRestService {

  @Inject
  private ConsoleOutput consoleOutput;

  @Inject
  private Employeemanagement employeemanagement;

  @Override
  public EmployeeEto getEmployee(long id) {

    try {
      this.consoleOutput.run("");
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return this.employeemanagement.findEmployee(id);
  }

  @Override
  public EmployeeEto saveEmployee(EmployeeEto employee) {

    return this.employeemanagement.saveEmployee(employee);
  }

  @Override
  public void deleteEmployee(long id) {

    this.employeemanagement.deleteEmployee(id);
  }

  @Override
  public PaginatedListTo<EmployeeEto> findEmployeesByPost(EmployeeSearchCriteriaTo searchCriteriaTo) {

    return this.employeemanagement.findEmployeeEtos(searchCriteriaTo);
  }

  @Override
  public EmployeeCto getEmployeeCto(long id) {

    return this.employeemanagement.findEmployeeCto(id);
  }

  @Override
  public PaginatedListTo<EmployeeCto> findEmployeeCtosByPost(EmployeeSearchCriteriaTo searchCriteriaTo) {

    return this.employeemanagement.findEmployeeCtos(searchCriteriaTo);
  }

}
