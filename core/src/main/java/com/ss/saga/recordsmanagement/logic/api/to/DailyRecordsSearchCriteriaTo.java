package com.ss.saga.recordsmanagement.logic.api.to;

import java.util.Date;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link com.ss.saga.recordsmanagement.common.api.DailyRecords}s.
 */
public class DailyRecordsSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private Double stockOpeningPrice;

  private Double stockClosingPrice;

  private Double stockPriceChange;

  private Double stockVolumn;

  private Long stockId;

  private Date recordDate;

  /**
   * The constructor.
   */
  public DailyRecordsSearchCriteriaTo() {

    super();
  }

  public Double getStockOpeningPrice() {

    return this.stockOpeningPrice;
  }

  public void setStockOpeningPrice(Double stockOpeningPrice) {

    this.stockOpeningPrice = stockOpeningPrice;
  }

  public Double getStockClosingPrice() {

    return this.stockClosingPrice;
  }

  public void setStockClosingPrice(Double stockClosingPrice) {

    this.stockClosingPrice = stockClosingPrice;
  }

  public Double getStockPriceChange() {

    return this.stockPriceChange;
  }

  public void setStockPriceChange(Double stockPriceChange) {

    this.stockPriceChange = stockPriceChange;
  }

  public Double getStockVolumn() {

    return this.stockVolumn;
  }

  public void setStockVolumn(Double stockVolumn) {

    this.stockVolumn = stockVolumn;
  }

  public Long getStockId() {

    return this.stockId;
  }

  public void setStockId(Long stockId) {

    this.stockId = stockId;
  }

  public Date getRecordDate() {

    return this.recordDate;
  }

  public void setRecordDate(Date recordDate) {

    this.recordDate = recordDate;
  }

}
