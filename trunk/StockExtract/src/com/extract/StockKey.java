package com.extract;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

import javax.xml.bind.annotation.XmlRootElement;


@Embeddable
public class StockKey implements Serializable{

	private String stockDate;
	private String ticker;
	public StockKey()
	{}
	public StockKey(String stockDate, String ticker)
	{
		this.stockDate = stockDate;
		this.ticker = ticker;
	}
	
	public String getStockDate() {
		return stockDate;
	}
	public void setStockDate(String stockDate) {
		this.stockDate = stockDate;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
}
