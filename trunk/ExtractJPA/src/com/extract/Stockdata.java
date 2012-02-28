package com.extract;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;


/**
 * @author Nandish
 * The persistent class for the stockdata database table.
 * 
 */
//@XmlRootElement
@XmlRootElement(name = "stockdata")
@XmlAccessorType(XmlAccessType.PROPERTY)
@Entity
@Table(name="stockdata")
public class Stockdata implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@EmbeddedId
	private StockdataPK id;
	
	private double close;

	private double high;

	private double low;

	private double open;

	private int volume;

    public Stockdata() {
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