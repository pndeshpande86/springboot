CREATE TABLE stock
(
  id bigint NOT NULL,
  modificationcounter integer NOT NULL,
  stockid bigint NOT NULL,
  stockcode character varying(256) NOT NULL,
  stockname character varying(256) NOT NULL,
  CONSTRAINT stock_pkey PRIMARY KEY (id),
  CONSTRAINT stock_stockcode_key UNIQUE (stockcode),
  CONSTRAINT stock_stockname_key UNIQUE (stockname)
)

CREATE TABLE stock_daily_records
(
  id bigint NOT NULL,
  modificationcounter integer NOT NULL,
  stock_open_price float NOT NULL,
  stock_close_price float NOT NULL,
  stock_price_change float NOT NULL,
  stock_volume float,
  stockid bigint,
  record_date Date,
  CONSTRAINT stock_daily_records_pkey PRIMARY KEY (id)
)