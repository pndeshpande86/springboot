package com.ss.saga.recordsmanagement.dataaccess.api.dao;

import com.ss.saga.general.dataaccess.api.dao.ApplicationDao;
import com.ss.saga.recordsmanagement.dataaccess.api.DailyRecordsEntity;
import com.ss.saga.recordsmanagement.logic.api.to.DailyRecordsSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for DailyRecords entities
 */
public interface DailyRecordsDao extends ApplicationDao<DailyRecordsEntity> {

  /**
   * Finds the {@link DailyRecordsEntity dailyrecordss} matching the given {@link DailyRecordsSearchCriteriaTo}.
   *
   * @param criteria is the {@link DailyRecordsSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link DailyRecordsEntity} objects.
   */
  PaginatedListTo<DailyRecordsEntity> findDailyRecordss(DailyRecordsSearchCriteriaTo criteria);

}
