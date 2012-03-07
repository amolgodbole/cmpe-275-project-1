package com.data.client;
 
import java.util.Iterator;
import java.util.List;
import javax.naming.Context;
import javax.naming.NamingException;
 
import com.data.business.StockProviderRemote;
import com.data.clientutility.JNDILookupClass;
import com.data.entity.Stockdata;
 
public class StockClient {
    private static final String LOOKUP_STRING = "StockProvider/remote";
 
    public static void main(String[] args) {
    	StockProviderRemote bean = doLookup();
 
    	//String str = bean.getAllData("JSON");
    	//String str = bean.getSpatialLocation("USA", "JSON");
    	String str = bean.getSpatialSector("Technology","JSON");
    	System.out.println("Remote result:"+str);
    	
   /* 	List<Stockdata> l = bean.getRealTimeData();
    	
    	Iterator<Stockdata> it = l.iterator();
    	while (it.hasNext())
    	{
    		System.out.println(it.next().getOpen());
    	}
    	*/
    
    }
 
    private static StockProviderRemote doLookup() {
        Context context = null;
        StockProviderRemote bean = null;
        try {
            // 1. Obtaining Context
            context = JNDILookupClass.getInitialContext();
            // 2. Lookup and cast
            bean = (StockProviderRemote) context.lookup(LOOKUP_STRING);
 
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return bean;
    }
}


