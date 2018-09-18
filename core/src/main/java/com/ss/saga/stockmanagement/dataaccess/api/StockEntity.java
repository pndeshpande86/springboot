package com.ss.saga.stockmanagement.dataaccess.api;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.ss.saga.general.dataaccess.api.ApplicationPersistenceEntity;
import com.ss.saga.recordsmanagement.dataaccess.api.DailyRecordsEntity;
import com.ss.saga.stockmanagement.common.api.Stock;

/**
 * @author pradeshp
 */
@Entity
@Table(name = "stock", uniqueConstraints = { @UniqueConstraint(columnNames = "stockcode"),
@UniqueConstraint(columnNames = "stockName") })
public class StockEntity extends ApplicationPersistenceEntity implements Stock {

  private long stockId;

  private String stockcode;

  private String stockName;

  private Set<DailyRecordsEntity> dailyRecords = new HashSet<>(0);

  private static final long serialVersionUID = 1L;

  /**
   * The constructor.
   */
  public StockEntity() {

    super();
  }

  StockEntity(String stockcode, String stockName) {

    this.stockcode = stockcode;
    this.stockName = stockName;
  }

  StockEntity(String stockcode, String stockName, Set<DailyRecordsEntity> dailyRecords) {

    this.stockcode = stockcode;
    this.stockName = stockName;
    this.dailyRecords = dailyRecords;
  }

  /**
   * @return stockId
   */
  @Column(name = "stockid", insertable = false, updatable = false)
  public long getStockId() {

    return this.stockId;
  }

  /**
   * @param stockId new value of {@link #getstockId}.
   */
  public void setStockId(long stockId) {

    this.stockId = stockId;
  }

  /**
   * @return stockcode
   */
  @Column(name = "stockcode")
  public String getStockcode() {

    return this.stockcode;
  }

  /**
   * @param stockcode new value of {@link #getstockcode}.
   */
  public void setStockcode(String stockcode) {

    this.stockcode = stockcode;
  }

  /**
   * @return stockName
   */
  @Column(name = "stockname")
  public String getStockName() {

    return this.stockName;
  }

  /**
   * @param stockName new value of {@link #getstockName}.
   */
  public void setStockName(String stockName) {

    this.stockName = stockName;
  }

  /**
   * @return dailyRecords
   */
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
  public Set<DailyRecordsEntity> getDailyRecords() {

    return this.dailyRecords;
  }

  /**
   * @param dailyRecords new value of {@link #getdailyRecords}.
   */
  public void setDailyRecords(Set<DailyRecordsEntity> dailyRecords) {

    this.dailyRecords = dailyRecords;
  }

}
