package com.ss.saga.stockmanagement.dataaccess.impl.dao;

import java.util.List;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;
import com.ss.saga.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.ss.saga.stockmanagement.dataaccess.api.StockEntity;
import com.ss.saga.stockmanagement.dataaccess.api.dao.StockDao;
import com.ss.saga.stockmanagement.logic.api.to.StockSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.OrderByTo;
import io.oasp.module.jpa.common.api.to.OrderDirection;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link StockDao}.
 */
@Named
public class StockDaoImpl extends ApplicationDaoImpl<StockEntity> implements StockDao {

  /**
   * The constructor.
   */
  public StockDaoImpl() {

    super();
  }

  @Override
  public Class<StockEntity> getEntityClass() {

    return StockEntity.class;
  }

  @Override
  public PaginatedListTo<StockEntity> findStocks(StockSearchCriteriaTo criteria) {

    StockEntity stock = Alias.alias(StockEntity.class);
    EntityPathBase<StockEntity> alias = Alias.$(stock);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    Long stockId = criteria.getStockId();
    if (stockId != null) {
      query.where(Alias.$(stock.getStockId()).eq(stockId));
    }
    String stockcode = criteria.getStockcode();
    if (stockcode != null) {
      query.where(Alias.$(stock.getStockcode()).eq(stockcode));
    }
    String stockName = criteria.getStockName();
    if (stockName != null) {
      query.where(Alias.$(stock.getStockName()).eq(stockName));
    }
    addOrderBy(query, alias, stock, criteria.getSort());

    return findPaginated(criteria, query, alias);
  }

  private void addOrderBy(JPAQuery query, EntityPathBase<StockEntity> alias, StockEntity stock, List<OrderByTo> sort) {

    if (sort != null && !sort.isEmpty()) {
      for (OrderByTo orderEntry : sort) {
        switch (orderEntry.getName()) {
          case "stockId":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(stock.getStockId()).asc());
            } else {
              query.orderBy(Alias.$(stock.getStockId()).desc());
            }
            break;
          case "stockcode":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(stock.getStockcode()).asc());
            } else {
              query.orderBy(Alias.$(stock.getStockcode()).desc());
            }
            break;
          case "stockName":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(stock.getStockName()).asc());
            } else {
              query.orderBy(Alias.$(stock.getStockName()).desc());
            }
            break;
        }
      }
    }
  }

}
