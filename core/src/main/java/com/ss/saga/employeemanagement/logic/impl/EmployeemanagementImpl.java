package com.ss.saga.employeemanagement.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.ss.saga.employeemanagement.dataaccess.api.EmployeeEntity;
import com.ss.saga.employeemanagement.dataaccess.api.dao.EmployeeDao;
import com.ss.saga.employeemanagement.logic.api.Employeemanagement;
import com.ss.saga.employeemanagement.logic.api.to.EmployeeCto;
import com.ss.saga.employeemanagement.logic.api.to.EmployeeEto;
import com.ss.saga.employeemanagement.logic.api.to.EmployeeSearchCriteriaTo;
import com.ss.saga.general.logic.base.AbstractComponentFacade;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.jpa.common.api.to.PaginationResultTo;

/**
 * Implementation of component interface of employeemanagement
 */
@Named
@Transactional
public class EmployeemanagementImpl extends AbstractComponentFacade implements Employeemanagement {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(EmployeemanagementImpl.class);

  /**
   * @see #getEmployeeDao()
   */
  @Inject
  private EmployeeDao employeeDao;

  /**
   * The constructor.
   */
  public EmployeemanagementImpl() {

    super();
  }

  @Override
  public EmployeeEto findEmployee(Long id) {

    LOG.debug("Get Employee with id {} from database.", id);
    return getBeanMapper().map(getEmployeeDao().findOne(id), EmployeeEto.class);
  }

  @Override
  public PaginatedListTo<EmployeeEto> findEmployeeEtos(EmployeeSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<EmployeeEntity> employees = getEmployeeDao().findEmployees(criteria);
    return mapPaginatedEntityList(employees, EmployeeEto.class);
  }

  @Override
  public boolean deleteEmployee(Long employeeId) {

    EmployeeEntity employee = getEmployeeDao().find(employeeId);
    getEmployeeDao().delete(employee);
    LOG.debug("The employee with id '{}' has been deleted.", employeeId);
    return true;
  }

  @Override
  public EmployeeEto saveEmployee(EmployeeEto employee) {

    Objects.requireNonNull(employee, "employee");
    EmployeeEntity employeeEntity = getBeanMapper().map(employee, EmployeeEntity.class);

    // initialize, validate employeeEntity here if necessary
    EmployeeEntity resultEntity = getEmployeeDao().save(employeeEntity);
    LOG.debug("Employee with id '{}' has been created.", resultEntity.getId());

    return getBeanMapper().map(resultEntity, EmployeeEto.class);
  }

  /**
   * Returns the field 'employeeDao'.
   *
   * @return the {@link EmployeeDao} instance.
   */
  public EmployeeDao getEmployeeDao() {

    return this.employeeDao;
  }

  @Override
  public EmployeeCto findEmployeeCto(Long id) {

    LOG.debug("Get EmployeeCto with id {} from database.", id);
    EmployeeEntity entity = getEmployeeDao().findOne(id);
    EmployeeCto cto = new EmployeeCto();
    cto.setEmployee(getBeanMapper().map(entity, EmployeeEto.class));

    return cto;
  }

  @Override
  public PaginatedListTo<EmployeeCto> findEmployeeCtos(EmployeeSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<EmployeeEntity> employees = getEmployeeDao().findEmployees(criteria);
    List<EmployeeCto> ctos = new ArrayList<>();
    for (EmployeeEntity entity : employees.getResult()) {
      EmployeeCto cto = new EmployeeCto();
      cto.setEmployee(getBeanMapper().map(entity, EmployeeEto.class));
      ctos.add(cto);

    }
    PaginationResultTo pagResultTo = new PaginationResultTo(criteria.getPagination(), (long) ctos.size());
    PaginatedListTo<EmployeeCto> pagListTo = new PaginatedListTo(ctos, pagResultTo);
    return pagListTo;
  }

}
