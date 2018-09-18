package com.ss.saga.stockmanagement.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.ss.saga.general.logic.base.AbstractComponentFacade;
import com.ss.saga.stockmanagement.dataaccess.api.StockEntity;
import com.ss.saga.stockmanagement.dataaccess.api.dao.StockDao;
import com.ss.saga.stockmanagement.logic.api.Stockmanagement;
import com.ss.saga.stockmanagement.logic.api.to.StockCto;
import com.ss.saga.stockmanagement.logic.api.to.StockEto;
import com.ss.saga.stockmanagement.logic.api.to.StockSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.jpa.common.api.to.PaginationResultTo;

/**
 * Implementation of component interface of stockmanagement
 */
@Named
@Transactional
public class StockmanagementImpl extends AbstractComponentFacade implements Stockmanagement {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(StockmanagementImpl.class);

  /**
   * @see #getStockDao()
   */
  @Inject
  private StockDao stockDao;

  /**
   * The constructor.
   */
  public StockmanagementImpl() {

    super();
  }

  @Override
  public StockEto findStock(Long id) {

    LOG.debug("Get Stock with id {} from database.", id);
    return getBeanMapper().map(getStockDao().findOne(id), StockEto.class);
  }

  @Override
  public PaginatedListTo<StockEto> findStockEtos(StockSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<StockEntity> stocks = getStockDao().findStocks(criteria);
    return mapPaginatedEntityList(stocks, StockEto.class);
  }

  @Override
  public boolean deleteStock(Long stockId) {

    StockEntity stock = getStockDao().find(stockId);
    getStockDao().delete(stock);
    LOG.debug("The stock with id '{}' has been deleted.", stockId);
    return true;
  }

  @Override
  public StockEto saveStock(StockEto stock) {

    Objects.requireNonNull(stock, "stock");
    StockEntity stockEntity = getBeanMapper().map(stock, StockEntity.class);

    // initialize, validate stockEntity here if necessary
    StockEntity resultEntity = getStockDao().save(stockEntity);
    LOG.debug("Stock with id '{}' has been created.", resultEntity.getId());

    return getBeanMapper().map(resultEntity, StockEto.class);
  }

  /**
   * Returns the field 'stockDao'.
   *
   * @return the {@link StockDao} instance.
   */
  public StockDao getStockDao() {

    return this.stockDao;
  }

  @Override
  public StockCto findStockCto(Long id) {

    LOG.debug("Get StockCto with id {} from database.", id);
    StockEntity entity = getStockDao().findOne(id);
    StockCto cto = new StockCto();
    cto.setStock(getBeanMapper().map(entity, StockEto.class));

    return cto;
  }

  @Override
  public PaginatedListTo<StockCto> findStockCtos(StockSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<StockEntity> stocks = getStockDao().findStocks(criteria);
    List<StockCto> ctos = new ArrayList<>();
    for (StockEntity entity : stocks.getResult()) {
      StockCto cto = new StockCto();
      cto.setStock(getBeanMapper().map(entity, StockEto.class));
      ctos.add(cto);

    }
    PaginationResultTo pagResultTo = new PaginationResultTo(criteria.getPagination(), (long) ctos.size());
    PaginatedListTo<StockCto> pagListTo = new PaginatedListTo(ctos, pagResultTo);
    return pagListTo;
  }

}
