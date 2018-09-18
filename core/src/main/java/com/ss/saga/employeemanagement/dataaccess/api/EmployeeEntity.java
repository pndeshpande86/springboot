package com.ss.saga.employeemanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ss.saga.employeemanagement.common.api.Employee;
import com.ss.saga.general.dataaccess.api.ApplicationPersistenceEntity;

/**
 * @author pradeshp
 */
@Entity
@Table(name = "employee")
public class EmployeeEntity extends ApplicationPersistenceEntity implements Employee {

  private long empId;

  private String empName;

  private double empSal;

  private String empDesg;

  private static final long serialVersionUID = 1L;

  /**
   * The constructor.
   */
  public EmployeeEntity() {

    super();
  }

  /**
   * @return empId
   */
  public long getEmpId() {

    return this.empId;
  }

  /**
   * @param empId new value of {@link #getempId}.
   */
  public void setEmpId(long empId) {

    this.empId = empId;
  }

  /**
   * @return empName
   */
  public String getEmpName() {

    return this.empName;
  }

  /**
   * @param empName new value of {@link #getempName}.
   */
  public void setEmpName(String empName) {

    this.empName = empName;
  }

  /**
   * @return empSal
   */
  public double getEmpSal() {

    return this.empSal;
  }

  /**
   * @param empSal new value of {@link #getempSal}.
   */
  public void setEmpSal(double empSal) {

    this.empSal = empSal;
  }

  /**
   * @return empDesg
   */
  public String getEmpDesg() {

    return this.empDesg;
  }

  /**
   * @param empDesg new value of {@link #getempDesg}.
   */
  public void setEmpDesg(String empDesg) {

    this.empDesg = empDesg;
  }

}
