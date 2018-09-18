package com.ss.saga.stockmanagement.logic.api.to;

import java.util.Set;

import com.ss.saga.general.common.api.to.AbstractEto;
import com.ss.saga.recordsmanagement.dataaccess.api.DailyRecordsEntity;
import com.ss.saga.stockmanagement.common.api.Stock;

/**
 * Entity transport object of Stock
 */
public class StockEto extends AbstractEto implements Stock {

  private static final long serialVersionUID = 1L;

  private long stockId;

  private String stockcode;

  private String stockName;

  private Set<DailyRecordsEntity> dailyRecords;

  @Override
  public long getStockId() {

    return this.stockId;
  }

  @Override
  public void setStockId(long stockId) {

    this.stockId = stockId;
  }

  @Override
  public String getStockcode() {

    return this.stockcode;
  }

  @Override
  public void setStockcode(String stockcode) {

    this.stockcode = stockcode;
  }

  @Override
  public String getStockName() {

    return this.stockName;
  }

  @Override
  public void setStockName(String stockName) {

    this.stockName = stockName;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((Long) this.stockId).hashCode();
    result = prime * result + ((this.stockcode == null) ? 0 : this.stockcode.hashCode());
    result = prime * result + ((this.stockName == null) ? 0 : this.stockName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    StockEto other = (StockEto) obj;
    if (this.stockId != other.stockId) {
      return false;
    }
    if (this.stockcode == null) {
      if (other.stockcode != null) {
        return false;
      }
    } else if (!this.stockcode.equals(other.stockcode)) {
      return false;
    }
    if (this.stockName == null) {
      if (other.stockName != null) {
        return false;
      }
    } else if (!this.stockName.equals(other.stockName)) {
      return false;
    }
    return true;
  }

  @Override
  public Set<DailyRecordsEntity> getDailyRecords() {

    return this.dailyRecords;
  }

  @Override
  public void setDailyRecords(Set<DailyRecordsEntity> dailyRecords) {

    this.dailyRecords = dailyRecords;
  }

}
