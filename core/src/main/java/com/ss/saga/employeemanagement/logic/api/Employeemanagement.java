package com.ss.saga.employeemanagement.logic.api;

import com.ss.saga.employeemanagement.logic.api.to.EmployeeCto;
import com.ss.saga.employeemanagement.logic.api.to.EmployeeEto;
import com.ss.saga.employeemanagement.logic.api.to.EmployeeSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Employeemanagement component.
 */
public interface Employeemanagement {

  /**
   * Returns a Employee by its id 'id'.
   *
   * @param id The id 'id' of the Employee.
   * @return The {@link EmployeeEto} with id 'id'
   */
  EmployeeEto findEmployee(Long id);

  /**
   * Returns a paginated list of Employees matching the search criteria.
   *
   * @param criteria the {@link EmployeeSearchCriteriaTo}.
   * @return the {@link List} of matching {@link EmployeeEto}s.
   */
  PaginatedListTo<EmployeeEto> findEmployeeEtos(EmployeeSearchCriteriaTo criteria);

  /**
   * Deletes a employee from the database by its id 'employeeId'.
   *
   * @param employeeId Id of the employee to delete
   * @return boolean <code>true</code> if the employee can be deleted, <code>false</code> otherwise
   */
  boolean deleteEmployee(Long employeeId);

  /**
   * Saves a employee and store it in the database.
   *
   * @param employee the {@link EmployeeEto} to create.
   * @return the new {@link EmployeeEto} that has been saved with ID and version.
   */
  EmployeeEto saveEmployee(EmployeeEto employee);

  /**
   * Returns a composite Employee by its id 'id'.
   *
   * @param id The id 'id' of the Employee.
   * @return The {@link EmployeeCto} with id 'id'
   */
  EmployeeCto findEmployeeCto(Long id);

  /**
   * Returns a paginated list of composite Employees matching the search criteria.
   *
   * @param criteria the {@link EmployeeSearchCriteriaTo}.
   * @return the {@link List} of matching {@link EmployeeCto}s.
   */
  PaginatedListTo<EmployeeCto> findEmployeeCtos(EmployeeSearchCriteriaTo criteria);

}
