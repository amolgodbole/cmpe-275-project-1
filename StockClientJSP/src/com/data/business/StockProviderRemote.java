package com.data.business;
import javax.ejb.Remote;

@Remote
public interface StockProviderRemote {
	public String getAllData(String format);
	public String getDownloadFile();
}
