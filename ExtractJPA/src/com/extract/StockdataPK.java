package com.extract;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * The primary key class for the stockdata database table.
 * 
 */
@Embeddable
public class StockdataPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String stockDate;
	
	private String ticker;

    public StockdataPK() {
    }
	public String getStockDate() {
		return this.stockDate;
	}
	public void setStockDate(String stockDate) {
		this.stockDate = stockDate;
	}
	public String getTicker() {
		return this.ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StockdataPK)) {
			return false;
		}
		StockdataPK castOther = (StockdataPK)other;
		return 
			this.stockDate.equals(castOther.stockDate)
			&& this.ticker.equals(castOther.ticker);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.stockDate.hashCode();
		hash = hash * prime + this.ticker.hashCode();
		
		return hash;
    }
}