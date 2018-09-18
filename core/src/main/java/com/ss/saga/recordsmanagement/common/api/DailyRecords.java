package com.ss.saga.recordsmanagement.common.api;

import java.util.Date;

import com.ss.saga.general.common.api.ApplicationEntity;

public interface DailyRecords extends ApplicationEntity {

  public double getStockOpeningPrice();

  public void setStockOpeningPrice(double stockOpeningPrice);

  public double getStockClosingPrice();

  public void setStockClosingPrice(double stockClosingPrice);

  public double getStockPriceChange();

  public void setStockPriceChange(double stockPriceChange);

  public double getStockVolumn();

  public void setStockVolumn(double stockVolumn);

  public long getStockId();

  public void setStockId(long stockId);

  public Date getRecordDate();

  public void setRecordDate(Date recordDate);

}
