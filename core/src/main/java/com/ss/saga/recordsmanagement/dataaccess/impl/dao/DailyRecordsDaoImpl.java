package com.ss.saga.recordsmanagement.dataaccess.impl.dao;

import java.util.Date;
import java.util.List;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;
import com.ss.saga.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.ss.saga.recordsmanagement.dataaccess.api.DailyRecordsEntity;
import com.ss.saga.recordsmanagement.dataaccess.api.dao.DailyRecordsDao;
import com.ss.saga.recordsmanagement.logic.api.to.DailyRecordsSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.OrderByTo;
import io.oasp.module.jpa.common.api.to.OrderDirection;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link DailyRecordsDao}.
 */
@Named
public class DailyRecordsDaoImpl extends ApplicationDaoImpl<DailyRecordsEntity> implements DailyRecordsDao {

  /**
   * The constructor.
   */
  public DailyRecordsDaoImpl() {

    super();
  }

  @Override
  public Class<DailyRecordsEntity> getEntityClass() {

    return DailyRecordsEntity.class;
  }

  @Override
  public PaginatedListTo<DailyRecordsEntity> findDailyRecordss(DailyRecordsSearchCriteriaTo criteria) {

    DailyRecordsEntity dailyrecords = Alias.alias(DailyRecordsEntity.class);
    EntityPathBase<DailyRecordsEntity> alias = Alias.$(dailyrecords);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    Double stockOpeningPrice = criteria.getStockOpeningPrice();
    if (stockOpeningPrice != null) {
      query.where(Alias.$(dailyrecords.getStockOpeningPrice()).eq(stockOpeningPrice));
    }
    Double stockClosingPrice = criteria.getStockClosingPrice();
    if (stockClosingPrice != null) {
      query.where(Alias.$(dailyrecords.getStockClosingPrice()).eq(stockClosingPrice));
    }
    Double stockPriceChange = criteria.getStockPriceChange();
    if (stockPriceChange != null) {
      query.where(Alias.$(dailyrecords.getStockPriceChange()).eq(stockPriceChange));
    }
    Double stockVolumn = criteria.getStockVolumn();
    if (stockVolumn != null) {
      query.where(Alias.$(dailyrecords.getStockVolumn()).eq(stockVolumn));
    }
    Long stockId = criteria.getStockId();
    if (stockId != null) {
      query.where(Alias.$(dailyrecords.getStockId()).eq(stockId));
    }
    Date recordDate = criteria.getRecordDate();
    if (recordDate != null) {
      query.where(Alias.$(dailyrecords.getRecordDate()).eq(recordDate));
    }
    addOrderBy(query, alias, dailyrecords, criteria.getSort());

    return findPaginated(criteria, query, alias);
  }

  private void addOrderBy(JPAQuery query, EntityPathBase<DailyRecordsEntity> alias, DailyRecordsEntity dailyrecords,
      List<OrderByTo> sort) {

    if (sort != null && !sort.isEmpty()) {
      for (OrderByTo orderEntry : sort) {
        switch (orderEntry.getName()) {
          case "stockOpeningPrice":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(dailyrecords.getStockOpeningPrice()).asc());
            } else {
              query.orderBy(Alias.$(dailyrecords.getStockOpeningPrice()).desc());
            }
            break;
          case "stockClosingPrice":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(dailyrecords.getStockClosingPrice()).asc());
            } else {
              query.orderBy(Alias.$(dailyrecords.getStockClosingPrice()).desc());
            }
            break;
          case "stockPriceChange":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(dailyrecords.getStockPriceChange()).asc());
            } else {
              query.orderBy(Alias.$(dailyrecords.getStockPriceChange()).desc());
            }
            break;
          case "stockVolumn":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(dailyrecords.getStockVolumn()).asc());
            } else {
              query.orderBy(Alias.$(dailyrecords.getStockVolumn()).desc());
            }
            break;
          case "stockId":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(dailyrecords.getStockId()).asc());
            } else {
              query.orderBy(Alias.$(dailyrecords.getStockId()).desc());
            }
            break;
          case "recordDate":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(dailyrecords.getRecordDate()).asc());
            } else {
              query.orderBy(Alias.$(dailyrecords.getRecordDate()).desc());
            }
            break;
        }
      }
    }
  }

}
