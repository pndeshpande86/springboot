package com.ss.saga.recordsmanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ss.saga.recordsmanagement.logic.api.Recordsmanagement;
import com.ss.saga.recordsmanagement.logic.api.to.DailyRecordsCto;
import com.ss.saga.recordsmanagement.logic.api.to.DailyRecordsEto;
import com.ss.saga.recordsmanagement.logic.api.to.DailyRecordsSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Recordsmanagement}.
 */
@Path("/recordsmanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface RecordsmanagementRestService {

  /**
   * Delegates to {@link Recordsmanagement#findDailyRecords}.
   *
   * @param id the ID of the {@link DailyRecordsEto}
   * @return the {@link DailyRecordsEto}
   */
  @GET
  @Path("/dailyrecords/{id}/")
  public DailyRecordsEto getDailyRecords(@PathParam("id") long id);

  /**
   * Delegates to {@link Recordsmanagement#saveDailyRecords}.
   *
   * @param dailyrecords the {@link DailyRecordsEto} to be saved
   * @return the recently created {@link DailyRecordsEto}
   */
  @POST
  @Path("/dailyrecords/")
  public DailyRecordsEto saveDailyRecords(DailyRecordsEto dailyrecords);

  /**
   * Delegates to {@link Recordsmanagement#deleteDailyRecords}.
   *
   * @param id ID of the {@link DailyRecordsEto} to be deleted
   */
  @DELETE
  @Path("/dailyrecords/{id}/")
  public void deleteDailyRecords(@PathParam("id") long id);

  /**
   * Delegates to {@link Recordsmanagement#findDailyRecordsEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding dailyrecordss.
   * @return the {@link PaginatedListTo list} of matching {@link DailyRecordsEto}s.
   */
  @Path("/dailyrecords/search")
  @POST
  public PaginatedListTo<DailyRecordsEto> findDailyRecordssByPost(DailyRecordsSearchCriteriaTo searchCriteriaTo);

  /**
   * Delegates to {@link Recordsmanagement#findDailyRecordsCto}.
   *
   * @param id the ID of the {@link DailyRecordsCto}
   * @return the {@link DailyRecordsCto}
   */
  @GET
  @Path("/dailyrecords/cto/{id}/")
  public DailyRecordsCto getDailyRecordsCto(@PathParam("id") long id);

  /**
   * Delegates to {@link Recordsmanagement#findDailyRecordsCtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding dailyrecordss.
   * @return the {@link PaginatedListTo list} of matching {@link DailyRecordsCto}s.
   */
  @Path("/dailyrecords/cto/search")
  @POST
  public PaginatedListTo<DailyRecordsCto> findDailyRecordsCtosByPost(DailyRecordsSearchCriteriaTo searchCriteriaTo);

}
