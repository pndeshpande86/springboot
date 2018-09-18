package com.ss.saga.stockmanagement.logic.api;

import com.ss.saga.stockmanagement.logic.api.to.StockCto;
import com.ss.saga.stockmanagement.logic.api.to.StockEto;
import com.ss.saga.stockmanagement.logic.api.to.StockSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Stockmanagement component.
 */
public interface Stockmanagement {

  /**
   * Returns a Stock by its id 'id'.
   *
   * @param id The id 'id' of the Stock.
   * @return The {@link StockEto} with id 'id'
   */
  StockEto findStock(Long id);

  /**
   * Returns a paginated list of Stocks matching the search criteria.
   *
   * @param criteria the {@link StockSearchCriteriaTo}.
   * @return the {@link List} of matching {@link StockEto}s.
   */
  PaginatedListTo<StockEto> findStockEtos(StockSearchCriteriaTo criteria);

  /**
   * Deletes a stock from the database by its id 'stockId'.
   *
   * @param stockId Id of the stock to delete
   * @return boolean <code>true</code> if the stock can be deleted, <code>false</code> otherwise
   */
  boolean deleteStock(Long stockId);

  /**
   * Saves a stock and store it in the database.
   *
   * @param stock the {@link StockEto} to create.
   * @return the new {@link StockEto} that has been saved with ID and version.
   */
  StockEto saveStock(StockEto stock);

  /**
   * Returns a composite Stock by its id 'id'.
   *
   * @param id The id 'id' of the Stock.
   * @return The {@link StockCto} with id 'id'
   */
  StockCto findStockCto(Long id);

  /**
   * Returns a paginated list of composite Stocks matching the search criteria.
   *
   * @param criteria the {@link StockSearchCriteriaTo}.
   * @return the {@link List} of matching {@link StockCto}s.
   */
  PaginatedListTo<StockCto> findStockCtos(StockSearchCriteriaTo criteria);

}
