package com.ss.saga.stockmanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import com.ss.saga.stockmanagement.logic.api.Stockmanagement;
import com.ss.saga.stockmanagement.logic.api.to.StockCto;
import com.ss.saga.stockmanagement.logic.api.to.StockEto;
import com.ss.saga.stockmanagement.logic.api.to.StockSearchCriteriaTo;
import com.ss.saga.stockmanagement.service.api.rest.StockmanagementRestService;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Stockmanagement}.
 */
@Named("StockmanagementRestService")
public class StockmanagementRestServiceImpl implements StockmanagementRestService {

  @Inject
  private Stockmanagement stockmanagement;

  @Override
  public StockEto getStock(long id) {

    return this.stockmanagement.findStock(id);
  }

  @Override
  public StockEto saveStock(StockEto stock) {

    return this.stockmanagement.saveStock(stock);
  }

  @Override
  public void deleteStock(long id) {

    this.stockmanagement.deleteStock(id);
  }

  @Override
  public PaginatedListTo<StockEto> findStocksByPost(StockSearchCriteriaTo searchCriteriaTo) {

    return this.stockmanagement.findStockEtos(searchCriteriaTo);
  }

  @Override
  public StockCto getStockCto(long id) {

    return this.stockmanagement.findStockCto(id);
  }

  @Override
  public PaginatedListTo<StockCto> findStockCtosByPost(StockSearchCriteriaTo searchCriteriaTo) {

    return this.stockmanagement.findStockCtos(searchCriteriaTo);
  }

}
