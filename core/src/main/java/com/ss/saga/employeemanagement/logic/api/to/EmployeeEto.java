package com.ss.saga.employeemanagement.logic.api.to;

import com.ss.saga.employeemanagement.common.api.Employee;
import com.ss.saga.general.common.api.to.AbstractEto;

/**
 * Entity transport object of Employee
 */
public class EmployeeEto extends AbstractEto implements Employee {

  private static final long serialVersionUID = 1L;

  private long empId;

  private String empName;

  private double empSal;

  private String empDesg;

  @Override
  public long getEmpId() {

    return this.empId;
  }

  @Override
  public void setEmpId(long empId) {

    this.empId = empId;
  }

  @Override
  public String getEmpName() {

    return this.empName;
  }

  @Override
  public void setEmpName(String empName) {

    this.empName = empName;
  }

  @Override
  public double getEmpSal() {

    return this.empSal;
  }

  @Override
  public void setEmpSal(double empSal) {

    this.empSal = empSal;
  }

  @Override
  public String getEmpDesg() {

    return this.empDesg;
  }

  @Override
  public void setEmpDesg(String empDesg) {

    this.empDesg = empDesg;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((Long) this.empId).hashCode();
    result = prime * result + ((this.empName == null) ? 0 : this.empName.hashCode());
    result = prime * result + ((Double) this.empSal).hashCode();
    result = prime * result + ((this.empDesg == null) ? 0 : this.empDesg.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    EmployeeEto other = (EmployeeEto) obj;
    if (this.empId != other.empId) {
      return false;
    }
    if (this.empName == null) {
      if (other.empName != null) {
        return false;
      }
    } else if (!this.empName.equals(other.empName)) {
      return false;
    }
    if (this.empSal != other.empSal) {
      return false;
    }
    if (this.empDesg == null) {
      if (other.empDesg != null) {
        return false;
      }
    } else if (!this.empDesg.equals(other.empDesg)) {
      return false;
    }
    return true;
  }

  /*
   * @Override public void setEmpSal(double empSal) {
   * 
   * this.empSal = empSal; }
   */

}
