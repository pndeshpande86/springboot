package com.ss.saga.recordsmanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import com.ss.saga.recordsmanagement.logic.api.Recordsmanagement;
import com.ss.saga.recordsmanagement.logic.api.to.DailyRecordsCto;
import com.ss.saga.recordsmanagement.logic.api.to.DailyRecordsEto;
import com.ss.saga.recordsmanagement.logic.api.to.DailyRecordsSearchCriteriaTo;
import com.ss.saga.recordsmanagement.service.api.rest.RecordsmanagementRestService;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Recordsmanagement}.
 */
@Named("RecordsmanagementRestService")
public class RecordsmanagementRestServiceImpl implements RecordsmanagementRestService {

  @Inject
  private Recordsmanagement recordsmanagement;

  @Override
  public DailyRecordsEto getDailyRecords(long id) {

    return this.recordsmanagement.findDailyRecords(id);
  }

  @Override
  public DailyRecordsEto saveDailyRecords(DailyRecordsEto dailyrecords) {

    return this.recordsmanagement.saveDailyRecords(dailyrecords);
  }

  @Override
  public void deleteDailyRecords(long id) {

    this.recordsmanagement.deleteDailyRecords(id);
  }

  @Override
  public PaginatedListTo<DailyRecordsEto> findDailyRecordssByPost(DailyRecordsSearchCriteriaTo searchCriteriaTo) {

    return this.recordsmanagement.findDailyRecordsEtos(searchCriteriaTo);
  }

  @Override
  public DailyRecordsCto getDailyRecordsCto(long id) {

    return this.recordsmanagement.findDailyRecordsCto(id);
  }

  @Override
  public PaginatedListTo<DailyRecordsCto> findDailyRecordsCtosByPost(DailyRecordsSearchCriteriaTo searchCriteriaTo) {

    return this.recordsmanagement.findDailyRecordsCtos(searchCriteriaTo);
  }

}
