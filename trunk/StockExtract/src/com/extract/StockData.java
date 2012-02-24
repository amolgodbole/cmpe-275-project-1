package com.extract;

import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table (name="stockdata")
public class StockData {

	StockKey stockKey;

	private double open;
	private double high;
	private double low;
	private double close;
	private int volume;
	
	
	@Id
	@Embedded
	public StockKey getStockKey() {
		return stockKey;
	}
	public void setStockKey(StockKey stockKey) {
		this.stockKey = stockKey;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
}
