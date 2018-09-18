package com.ss.saga.employeemanagement.dataaccess.impl.dao;

import java.util.List;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;
import com.ss.saga.employeemanagement.dataaccess.api.EmployeeEntity;
import com.ss.saga.employeemanagement.dataaccess.api.dao.EmployeeDao;
import com.ss.saga.employeemanagement.logic.api.to.EmployeeSearchCriteriaTo;
import com.ss.saga.general.dataaccess.base.dao.ApplicationDaoImpl;

import io.oasp.module.jpa.common.api.to.OrderByTo;
import io.oasp.module.jpa.common.api.to.OrderDirection;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link EmployeeDao}.
 */
@Named
public class EmployeeDaoImpl extends ApplicationDaoImpl<EmployeeEntity> implements EmployeeDao {

  /**
   * The constructor.
   */
  public EmployeeDaoImpl() {

    super();
  }

  @Override
  public Class<EmployeeEntity> getEntityClass() {

    return EmployeeEntity.class;
  }

  @Override
  public PaginatedListTo<EmployeeEntity> findEmployees(EmployeeSearchCriteriaTo criteria) {

    EmployeeEntity employee = Alias.alias(EmployeeEntity.class);
    EntityPathBase<EmployeeEntity> alias = Alias.$(employee);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    Long empId = criteria.getEmpId();
    if (empId != null) {
      query.where(Alias.$(employee.getEmpId()).eq(empId));
    }
    String empName = criteria.getEmpName();
    if (empName != null) {
      query.where(Alias.$(employee.getEmpName()).eq(empName));
    }
    Double empSal = criteria.getEmpSal();
    if (empSal != null) {
      query.where(Alias.$(employee.getEmpSal()).eq(empSal));
    }
    String empDesg = criteria.getEmpDesg();
    if (empDesg != null) {
      query.where(Alias.$(employee.getEmpDesg()).eq(empDesg));
    }
    addOrderBy(query, alias, employee, criteria.getSort());

    return findPaginated(criteria, query, alias);
  }

  private void addOrderBy(JPAQuery query, EntityPathBase<EmployeeEntity> alias, EmployeeEntity employee,
      List<OrderByTo> sort) {

    if (sort != null && !sort.isEmpty()) {
      for (OrderByTo orderEntry : sort) {
        switch (orderEntry.getName()) {
          case "empId":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(employee.getEmpId()).asc());
            } else {
              query.orderBy(Alias.$(employee.getEmpId()).desc());
            }
            break;
          case "empName":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(employee.getEmpName()).asc());
            } else {
              query.orderBy(Alias.$(employee.getEmpName()).desc());
            }
            break;
          case "empSal":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(employee.getEmpSal()).asc());
            } else {
              query.orderBy(Alias.$(employee.getEmpSal()).desc());
            }
            break;
          case "empDesg":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(employee.getEmpDesg()).asc());
            } else {
              query.orderBy(Alias.$(employee.getEmpDesg()).desc());
            }
            break;
        }
      }
    }
  }

}
