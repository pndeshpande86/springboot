package com.ss.saga.employeemanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link com.ss.saga.employeemanagement.common.api.Employee}s.
 */
public class EmployeeSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private Long empId;

  private String empName;

  private Double empSal;

  private String empDesg;

  /**
   * The constructor.
   */
  public EmployeeSearchCriteriaTo() {

    super();
  }

  public Long getEmpId() {

    return this.empId;
  }

  public void setEmpId(Long empId) {

    this.empId = empId;
  }

  public String getEmpName() {

    return this.empName;
  }

  public void setEmpName(String empName) {

    this.empName = empName;
  }

  public Double getEmpSal() {

    return this.empSal;
  }

  public void setEmpSal(Double empSal) {

    this.empSal = empSal;
  }

  public String getEmpDesg() {

    return this.empDesg;
  }

  public void setEmpDesg(String empDesg) {

    this.empDesg = empDesg;
  }

  /*
   * public void setEmpSal(Double empSal) {
   * 
   * this.empSal = empSal; }
   */

}
