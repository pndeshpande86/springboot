package com.ss.saga.stockmanagement.logic.api.to;

import java.util.Set;

import com.ss.saga.general.common.api.to.AbstractCto;
import com.ss.saga.recordsmanagement.logic.api.to.DailyRecordsEto;

/**
 * Composite transport object of Stock
 */
public class StockCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private StockEto stock;

  private Set<DailyRecordsEto> dailyRecords;

  public StockEto getStock() {

    return stock;
  }

  public void setStock(StockEto stock) {

    this.stock = stock;
  }

  public Set<DailyRecordsEto> getDailyRecords() {

    return dailyRecords;
  }

  public void setDailyRecords(Set<DailyRecordsEto> dailyRecords) {

    this.dailyRecords = dailyRecords;
  }

}
