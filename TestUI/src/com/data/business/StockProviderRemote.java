package com.data.business;
import java.util.List;

import javax.ejb.Remote;

import com.data.entity.Stockdata;

@Remote
public interface StockProviderRemote {
	public String getAllData(String format);
	//public List<Stockdata> getRealTimeData();
	public List<Stockdata> extract();
	public List<Stockdata> getExtract();
}
