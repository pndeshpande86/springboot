package com.ss.saga.employeemanagement.dataaccess.api.dao;

import com.ss.saga.employeemanagement.dataaccess.api.EmployeeEntity;
import com.ss.saga.employeemanagement.logic.api.to.EmployeeSearchCriteriaTo;
import com.ss.saga.general.dataaccess.api.dao.ApplicationDao;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Employee entities
 */
public interface EmployeeDao extends ApplicationDao<EmployeeEntity> {

  /**
   * Finds the {@link EmployeeEntity employees} matching the given {@link EmployeeSearchCriteriaTo}.
   *
   * @param criteria is the {@link EmployeeSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link EmployeeEntity} objects.
   */
  PaginatedListTo<EmployeeEntity> findEmployees(EmployeeSearchCriteriaTo criteria);

}
