package com.ss.saga.stockmanagement.dataaccess.api.dao;

import com.ss.saga.general.dataaccess.api.dao.ApplicationDao;
import com.ss.saga.stockmanagement.dataaccess.api.StockEntity;
import com.ss.saga.stockmanagement.logic.api.to.StockSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Stock entities
 */
public interface StockDao extends ApplicationDao<StockEntity> {

  /**
   * Finds the {@link StockEntity stocks} matching the given {@link StockSearchCriteriaTo}.
   *
   * @param criteria is the {@link StockSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link StockEntity} objects.
   */
  PaginatedListTo<StockEntity> findStocks(StockSearchCriteriaTo criteria);

}
