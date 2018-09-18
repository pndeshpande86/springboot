package com.ss.saga.recordsmanagement.logic.api;

import com.ss.saga.recordsmanagement.logic.api.to.DailyRecordsCto;
import com.ss.saga.recordsmanagement.logic.api.to.DailyRecordsEto;
import com.ss.saga.recordsmanagement.logic.api.to.DailyRecordsSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Recordsmanagement component.
 */
public interface Recordsmanagement {

  /**
   * Returns a DailyRecords by its id 'id'.
   *
   * @param id The id 'id' of the DailyRecords.
   * @return The {@link DailyRecordsEto} with id 'id'
   */
  DailyRecordsEto findDailyRecords(Long id);

  /**
   * Returns a paginated list of DailyRecordss matching the search criteria.
   *
   * @param criteria the {@link DailyRecordsSearchCriteriaTo}.
   * @return the {@link List} of matching {@link DailyRecordsEto}s.
   */
  PaginatedListTo<DailyRecordsEto> findDailyRecordsEtos(DailyRecordsSearchCriteriaTo criteria);

  /**
   * Deletes a dailyRecords from the database by its id 'dailyRecordsId'.
   *
   * @param dailyRecordsId Id of the dailyRecords to delete
   * @return boolean <code>true</code> if the dailyRecords can be deleted, <code>false</code> otherwise
   */
  boolean deleteDailyRecords(Long dailyRecordsId);

  /**
   * Saves a dailyRecords and store it in the database.
   *
   * @param dailyRecords the {@link DailyRecordsEto} to create.
   * @return the new {@link DailyRecordsEto} that has been saved with ID and version.
   */
  DailyRecordsEto saveDailyRecords(DailyRecordsEto dailyRecords);

  /**
   * Returns a composite DailyRecords by its id 'id'.
   *
   * @param id The id 'id' of the DailyRecords.
   * @return The {@link DailyRecordsCto} with id 'id'
   */
  DailyRecordsCto findDailyRecordsCto(Long id);

  /**
   * Returns a paginated list of composite DailyRecordss matching the search criteria.
   *
   * @param criteria the {@link DailyRecordsSearchCriteriaTo}.
   * @return the {@link List} of matching {@link DailyRecordsCto}s.
   */
  PaginatedListTo<DailyRecordsCto> findDailyRecordsCtos(DailyRecordsSearchCriteriaTo criteria);

}
