package com.ss.saga.recordsmanagement.logic.api.to;

import java.util.Date;

import com.ss.saga.general.common.api.to.AbstractEto;
import com.ss.saga.recordsmanagement.common.api.DailyRecords;

/**
 * Entity transport object of DailyRecords
 */
public class DailyRecordsEto extends AbstractEto implements DailyRecords {

  private static final long serialVersionUID = 1L;

  private double stockOpeningPrice;

  private double stockClosingPrice;

  private double stockPriceChange;

  private double stockVolumn;

  private long stockId;

  private Date recordDate;

  @Override
  public double getStockOpeningPrice() {

    return this.stockOpeningPrice;
  }

  @Override
  public void setStockOpeningPrice(double stockOpeningPrice) {

    this.stockOpeningPrice = stockOpeningPrice;
  }

  @Override
  public double getStockClosingPrice() {

    return this.stockClosingPrice;
  }

  @Override
  public void setStockClosingPrice(double stockClosingPrice) {

    this.stockClosingPrice = stockClosingPrice;
  }

  @Override
  public double getStockPriceChange() {

    return this.stockPriceChange;
  }

  @Override
  public void setStockPriceChange(double stockPriceChange) {

    this.stockPriceChange = stockPriceChange;
  }

  @Override
  public double getStockVolumn() {

    return this.stockVolumn;
  }

  @Override
  public void setStockVolumn(double stockVolumn) {

    this.stockVolumn = stockVolumn;
  }

  @Override
  public long getStockId() {

    return this.stockId;
  }

  @Override
  public void setStockId(long stockId) {

    this.stockId = stockId;
  }

  @Override
  public Date getRecordDate() {

    return this.recordDate;
  }

  @Override
  public void setRecordDate(Date recordDate) {

    this.recordDate = recordDate;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((Double) this.stockOpeningPrice).hashCode();
    result = prime * result + ((Double) this.stockClosingPrice).hashCode();
    result = prime * result + ((Double) this.stockPriceChange).hashCode();
    result = prime * result + ((Double) this.stockVolumn).hashCode();
    result = prime * result + ((Long) this.stockId).hashCode();
    result = prime * result + ((this.recordDate == null) ? 0 : this.recordDate.hashCode());
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
    DailyRecordsEto other = (DailyRecordsEto) obj;
    if (this.stockOpeningPrice != other.stockOpeningPrice) {
      return false;
    }
    if (this.stockClosingPrice != other.stockClosingPrice) {
      return false;
    }
    if (this.stockPriceChange != other.stockPriceChange) {
      return false;
    }
    if (this.stockVolumn != other.stockVolumn) {
      return false;
    }
    if (this.stockId != other.stockId) {
      return false;
    }
    if (this.recordDate == null) {
      if (other.recordDate != null) {
        return false;
      }
    } else if (!this.recordDate.equals(other.recordDate)) {
      return false;
    }
    return true;
  }

}
