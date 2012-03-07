package com.data.client;
 
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    	
    	//listing all sectors
    	System.out.println("Sectors:");
    	List<String> sec = bean.getSector();
    	Iterator<String> it_sec = sec.iterator();
    	while (it_sec.hasNext())
    	{
    		//System.out.println(it.next().getOpen());
    		System.out.println(it_sec.next());
    	}
    	
    	//listing all industry
    	System.out.println("Industry:");
    	List<String> ind = bean.getIndustry();
    	Iterator<String> it_ind = ind.iterator();
    	while (it_ind.hasNext())
    	{
    		//System.out.println(it.next().getOpen());
    		System.out.println(it_ind.next());
    	}    	
    	
    	//listing all Location
    	System.out.println("Location:");
    	List<String> loc = bean.getLocation();
    	Iterator<String> it_loc = loc.iterator();
    	while (it_loc.hasNext())
    	{
    		//System.out.println(it.next().getOpen());
    		System.out.println(it_loc.next());
    	}
    	
    	//listing all Ticker
    	System.out.println("Ticker:");
    	List<String> tic = bean.getTicker();
    	Iterator<String> it_tic = tic.iterator();
    	while (it_tic.hasNext())
    	{
    		//System.out.println(it.next().getOpen());
    		System.out.println(it_tic.next());
    	}
    	
    	//String str = bean.getAllData("CSV");
    	//String str = bean.getSpatialLocation("USA", "JSON");
    	//String str = bean.getSpatialSector("Technology","JSON");
    	//System.out.println("Remote result:"+str);
    	
   /* 	String curr = new String();
    	
    	final String DATE_FORMAT_NOW = "yyyyMMdd";	
    	Calendar cal = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
    	curr = sdf.format(cal.getTime());
    	System.out.println("Date:"+curr);
    	
    	List<Stockdata> l = bean.getRealTimeData();
    	
    	Iterator<Stockdata> it = l.iterator();
    	while (it.hasNext())
    	{
    		//System.out.println(it.next().getOpen());
    		System.out.println(it.next().getId().getTicker());
    		System.out.println(it.next().getId().getStockDate());
    		System.out.println(it.next().getOpen());
    		System.out.println(it.next().getHigh());
    	}*/
    	
    
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


