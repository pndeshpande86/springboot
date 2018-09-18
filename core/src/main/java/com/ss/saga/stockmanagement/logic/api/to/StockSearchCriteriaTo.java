package com.ss.saga.stockmanagement.logic.api.to;

import java.util.Set;

import com.ss.saga.recordsmanagement.dataaccess.api.DailyRecordsEntity;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link com.ss.saga.stockmanagement.common.api.Stock}s.
 */
public class StockSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private Long stockId;

  private String stockcode;

  private String stockName;

  private Set<DailyRecordsEntity> dailyRecords;

  /**
   * The constructor.
   */
  public StockSearchCriteriaTo() {

    super();
  }

  public Long getStockId() {

    return this.stockId;
  }

  public void setStockId(Long stockId) {

    this.stockId = stockId;
  }

  public String getStockcode() {

    return this.stockcode;
  }

  public void setStockcode(String stockcode) {

    this.stockcode = stockcode;
  }

  public String getStockName() {

    return this.stockName;
  }

  public void setStockName(String stockName) {

    this.stockName = stockName;
  }

  public Set getDailyRecords() {

    return this.dailyRecords;
  }

  public void setDailyRecords(Set dailyRecords) {

    this.dailyRecords = dailyRecords;
  }

}
