package com.data.business;
import java.util.List;

import javax.ejb.Remote;

import com.data.entity.Stockdata;

@Remote
public interface StockProviderRemote {
	
	//Realtime
	public List<Stockdata> getRealTimeData();
	//Historical
	public String getAllData(String format);
	public List<Stockdata> extract();
	//Temporal
	public String getTemporalData(String StartDate, String EndDate, String format);	
	//Spatial data
	public String getSpatialLocation(String location, String format);
	public String getSpatialIndustry(String industry, String format);
	public String getSpatialSector(String sector, String format);
	//Ticker information	
	public List<String> getTicker();
	public List<String> getLocation();
	public List<String> getSector();
	public List<String> getIndustry();
}
