package com.ss.saga.recordsmanagement.logic.api.to;

import com.ss.saga.general.common.api.to.AbstractCto;

/**
 * Composite transport object of DailyRecords
 */
public class DailyRecordsCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private DailyRecordsEto dailyRecords;

  public DailyRecordsEto getDailyRecords() {

    return dailyRecords;
  }

  public void setDailyRecords(DailyRecordsEto dailyRecords) {

    this.dailyRecords = dailyRecords;
  }

}
