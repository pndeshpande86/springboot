package com.ss.saga.stockmanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ss.saga.stockmanagement.logic.api.Stockmanagement;
import com.ss.saga.stockmanagement.logic.api.to.StockCto;
import com.ss.saga.stockmanagement.logic.api.to.StockEto;
import com.ss.saga.stockmanagement.logic.api.to.StockSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Stockmanagement}.
 */
@Path("/stockmanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface StockmanagementRestService {

  /**
   * Delegates to {@link Stockmanagement#findStock}.
   *
   * @param id the ID of the {@link StockEto}
   * @return the {@link StockEto}
   */
  @GET
  @Path("/stock/{id}/")
  public StockEto getStock(@PathParam("id") long id);

  /**
   * Delegates to {@link Stockmanagement#saveStock}.
   *
   * @param stock the {@link StockEto} to be saved
   * @return the recently created {@link StockEto}
   */
  @POST
  @Path("/stock/")
  public StockEto saveStock(StockEto stock);

  /**
   * Delegates to {@link Stockmanagement#deleteStock}.
   *
   * @param id ID of the {@link StockEto} to be deleted
   */
  @DELETE
  @Path("/stock/{id}/")
  public void deleteStock(@PathParam("id") long id);

  /**
   * Delegates to {@link Stockmanagement#findStockEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding stocks.
   * @return the {@link PaginatedListTo list} of matching {@link StockEto}s.
   */
  @Path("/stock/search")
  @POST
  public PaginatedListTo<StockEto> findStocksByPost(StockSearchCriteriaTo searchCriteriaTo);

  /**
   * Delegates to {@link Stockmanagement#findStockCto}.
   *
   * @param id the ID of the {@link StockCto}
   * @return the {@link StockCto}
   */
  @GET
  @Path("/stock/cto/{id}/")
  public StockCto getStockCto(@PathParam("id") long id);

  /**
   * Delegates to {@link Stockmanagement#findStockCtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding stocks.
   * @return the {@link PaginatedListTo list} of matching {@link StockCto}s.
   */
  @Path("/stock/cto/search")
  @POST
  public PaginatedListTo<StockCto> findStockCtosByPost(StockSearchCriteriaTo searchCriteriaTo);

}
