package com.ss.saga.employeemanagement.common.api;

import com.ss.saga.general.common.api.ApplicationEntity;

public interface Employee extends ApplicationEntity {

  public long getEmpId();

  public void setEmpId(long empId);

  public String getEmpName();

  public void setEmpName(String empName);

  public double getEmpSal();

  public void setEmpSal(double empSal);

  public String getEmpDesg();

  public void setEmpDesg(String empDesg);

  /* public void setEmpSal(double empSal); */

}
