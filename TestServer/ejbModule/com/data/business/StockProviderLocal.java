package com.data.business;
import java.util.List;

import javax.ejb.Local;

import com.data.entity.Stockdata;

@Local
public interface StockProviderLocal {
	public String getAllData(String format);
	public List<Stockdata> getRealTimeData();
	public List<Stockdata> extract();
	//public List<Stockdata> getExtract();
}
