package com.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import com.data.business.StockProviderRemote;

public class StockDataClient {

	
	public String getAllData(String format)
	{
		String result;
		try{
			Properties properties = new Properties();
			properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			properties.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			Context ctx = new InitialContext(properties);
			Object ref = ctx.lookup("StockProvider/remote");
			StockProviderRemote stock = (StockProviderRemote) PortableRemoteObject.narrow(ref, StockProviderRemote.class);
			
			result = stock.getAllData(format);
			return result;	
			
		}
		catch(Exception e)
		{
			return null;
		}
	
		
	}
	
}
