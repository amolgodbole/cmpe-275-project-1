package com.stocks.entity;

public class StockData {
	
private StockdataPK id;
	
	private double close;

	private double high;

	private double low;

	private double open;

	private int volume;

    public StockData() {
    }

	public StockdataPK getId() {
		return this.id;
	}

	public void setId(StockdataPK id) {
		this.id = id;
	}
	
	public double getClose() {
		return this.close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getHigh() {
		return this.high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return this.low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getOpen() {
		return this.open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public int getVolume() {
		return this.volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

}
