package com.ss.saga.stockmanagement.common.api;

import java.util.Set;

import com.ss.saga.general.common.api.ApplicationEntity;
import com.ss.saga.recordsmanagement.dataaccess.api.DailyRecordsEntity;

public interface Stock extends ApplicationEntity {

  public long getStockId();

  public void setStockId(long stockId);

  public String getStockcode();

  public void setStockcode(String stockcode);

  public String getStockName();

  public void setStockName(String stockName);

  public Set<DailyRecordsEntity> getDailyRecords();

  public void setDailyRecords(Set<DailyRecordsEntity> dailyRecords);

}
