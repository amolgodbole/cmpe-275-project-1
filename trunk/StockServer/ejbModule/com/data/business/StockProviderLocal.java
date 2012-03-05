package com.data.business;
import javax.ejb.Local;

@Local
public interface StockProviderLocal {
	public String getAllData(String format);
}
