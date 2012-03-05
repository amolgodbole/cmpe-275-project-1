/**
 * 
 */
package com.Stocks.entity;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import com.data.business.StockProviderRemote;

/**
 * @author amolgodbole
 *
 */
public class StockDataMB {

	private double close;
	private double high;
	private double low;
	private double open;
	private int volume;
	private String ticker;
	private List<StockData> stockdata;
	private String message;
	
	
	public StockDataMB() 
	{
		try{
			Properties properties = new Properties();
			properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			properties.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			Context ctx = new InitialContext(properties);
			Object ref = ctx.lookup("StockProvider/remote");
			StockProviderRemote stock = (StockProviderRemote) PortableRemoteObject.narrow(ref, StockProviderRemote.class);
			
			String result = stock.getAllData();
			
			
		}
		catch(Exception e)
		{
			this.message = e.getMessage();
		}

	}

	public List<StockData> getStockdata() {
		return stockdata;
	}

	public void setStockdata(List<StockData> stockdata) {
		this.stockdata = stockdata;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
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

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void getRealTimeData()
	{
		try{
			Properties properties = new Properties();
			properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			properties.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			Context ctx = new InitialContext(properties);
			Object ref = ctx.lookup("StockProvider/remote");
			StockProviderRemote stock = (StockProviderRemote) PortableRemoteObject.narrow(ref, StockProviderRemote.class);
			
			String result = stock.getAllData();
			
			
		}
		catch(Exception e)
		{
			this.message = e.getMessage();
		}
	}


}
