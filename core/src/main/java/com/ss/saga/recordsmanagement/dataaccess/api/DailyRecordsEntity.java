package com.ss.saga.recordsmanagement.dataaccess.api;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.ss.saga.general.dataaccess.api.ApplicationPersistenceEntity;
import com.ss.saga.recordsmanagement.common.api.DailyRecords;
import com.ss.saga.stockmanagement.dataaccess.api.StockEntity;

/**
 * @author pradeshp
 */
@Entity
@Table(name = "stock_daily_records", uniqueConstraints = @UniqueConstraint(columnNames = "record_date"))
public class DailyRecordsEntity extends ApplicationPersistenceEntity implements DailyRecords {

  private double stockOpeningPrice;

  private double stockClosingPrice;

  private double stockPriceChange;

  private double stockVolumn;

  private long stockId;

  private Date recordDate;

  private StockEntity stock;

  private static final long serialVersionUID = 1L;

  /**
   * The constructor.
   */
  public DailyRecordsEntity() {

    super();
  }

  /**
   * @return stockOpeningPrice
   */
  @Column(name = "stock_open_price")
  public double getStockOpeningPrice() {

    return this.stockOpeningPrice;
  }

  /**
   * @param stockOpeningPrice new value of {@link #getstockOpeningPrice}.
   */
  public void setStockOpeningPrice(double stockOpeningPrice) {

    this.stockOpeningPrice = stockOpeningPrice;
  }

  /**
   * @return stockClosingPrice
   */
  @Column(name = "stock_close_price")
  public double getStockClosingPrice() {

    return this.stockClosingPrice;
  }

  /**
   * @param stockClosingPrice new value of {@link #getstockClosingPrice}.
   */
  public void setStockClosingPrice(double stockClosingPrice) {

    this.stockClosingPrice = stockClosingPrice;
  }

  /**
   * @return stockPriceChange
   */
  @Column(name = "stock_price_change")
  public double getStockPriceChange() {

    return this.stockPriceChange;
  }

  /**
   * @param stockPriceChange new value of {@link #getstockPriceChange}.
   */
  public void setStockPriceChange(double stockPriceChange) {

    this.stockPriceChange = stockPriceChange;
  }

  /**
   * @return stockVolumn
   */
  @Column(name = "stock_volume")
  public double getStockVolumn() {

    return this.stockVolumn;
  }

  /**
   * @param stockVolumn new value of {@link #getstockVolumn}.
   */
  public void setStockVolumn(double stockVolumn) {

    this.stockVolumn = stockVolumn;
  }

  /**
   * @return stockId
   */
  @Column(name = "stockid", insertable = false, updatable = false, nullable = false)
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
   * @return recordDate
   */
  @Column(name = "record_date", columnDefinition = "DATE", nullable = false)
  public Date getRecordDate() {

    return this.recordDate;
  }

  /**
   * @param recordDate new value of {@link #getrecordDate}.
   */
  public void setRecordDate(Date recordDate) {

    this.recordDate = recordDate;
  }

  /**
   * @return stock
   */
  @ManyToOne
  @JoinColumn(name = "stockid", nullable = false)
  public StockEntity getStock() {

    return null;
  }

  /**
   * @param stock new value of {@link #getstock}.
   */
  public void setStock(StockEntity stock) {

    this.stock = stock;
  }

}
