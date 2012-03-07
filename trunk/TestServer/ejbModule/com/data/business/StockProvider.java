package com.data.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.data.builder.IBuilder;
import com.data.builder.JsonBuilder;
import com.data.builder.XmlBuilder;
import com.data.builder.CSVBuilder;
import com.data.entity.Stockdata;
import com.data.entity.Ticker;
import com.jms.response.ResponseProducer;




/**
 * Session Bean implementation class StockProvider
 */
@Stateless
public class StockProvider implements StockProviderRemote, StockProviderLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName = "JPADB")
	EntityManager em;
	//EntityManagerFactory emf;
    public StockProvider() {
    	//emf = Persistence.createEntityManagerFactory("JPADB");
		//em = emf.createEntityManager();
    }

    public enum SerializationType{XML, JSON, CSV};
	
	public IBuilder get_builder(SerializationType type)
	{
		switch(type)
		{
			case XML:
				return new XmlBuilder();		//if type is XML, call XmlBuilder.
				
			case JSON:
				return new JsonBuilder();		//if type is JSON, call JsonBuilder
				
			case CSV:
				return new CSVBuilder();		//if type is CSV, call CSVBuilder
				
		}
		return null;
	}
	
	public String encode(List<Stockdata> msg, String trantype)
	{
		SerializationType type = SerializationType.JSON;
		if (trantype.equalsIgnoreCase("XML")){
			type = SerializationType.XML;
		}else if (trantype.equalsIgnoreCase("JSON")){
			type = SerializationType.JSON;
		}else if (trantype.equalsIgnoreCase("CSV")){
			type = SerializationType.CSV;
		}
		return get_builder(type).encode(msg);
		
	}
	
	public String getSpatialData(String format, String ticker, boolean range, String StartDate, String EndDate)
	{
		//ExtractData data = new ExtractData();
		if(range) //gets the spatial data for the specified region with date range
		{
			return encode(extractSpatialData(ticker, StartDate, EndDate), format);
		}
		else //gets the spatial entire dataset for the specified region
		{		
			return encode(extractAllSpatialData(ticker), format);
		}
		
	}
	
	@Override
	public String getTemporalData(String StartDate, String EndDate, String format)
	{
		//ExtractData data = new ExtractData();
		return encode(extractTemporalData(StartDate, EndDate), format);
	}

	
	@Override
	public String getAllData(String format)
	{
		//ExtractData data = new ExtractData();
		System.out.println("get all data");
		/*//-----Sending on JMS
		try {
			System.out.println("trying to send..on queue");
			String str = encode(extract(), format);		
			ResponseProducer c = new ResponseProducer();		
			c.sendResponse(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("in getallData exception");
		}
		//--------------
*/		return encode(extract(), format);
	}
	
	@Override
	public String getSpatialLocation(String location, String format)
	{	
		return encode(extractSpatialLocation(location), format);
	}
	@Override
	public String getSpatialIndustry(String industry, String format)
	{	
		return encode(extractSpatialIndustry(industry), format);
	}
	@Override
	public String getSpatialSector(String sector, String format)
	{	
		System.out.println("get sector");
		return encode(extractSpatialSector(sector), format);
	}
	
	// Extract Methods*************************************************************************************************
	//getSpatialData - gets the spatial data with region and range
	public List<Stockdata> extractSpatialData(String ticker, String StartDate, String EndDate)
	{
		em.getTransaction().begin();

	    TypedQuery<Stockdata> query = em.createQuery("SELECT st FROM Stockdata st WHERE st.id.ticker = :ticker AND st.id.stockDate BETWEEN :StartDate AND :EndDate", Stockdata.class);
		query.setParameter("ticker", ticker);
		query.setParameter("StartDate", StartDate);
		query.setParameter("EndDate", EndDate);

		List<Stockdata> lst = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return lst;
	}
	//getSpatialData - gets all the spatial data for the region
	public List<Stockdata> extractAllSpatialData(String ticker)
	{
		em.getTransaction().begin();

	    TypedQuery<Stockdata> query = em.createQuery("SELECT st FROM Stockdata st WHERE st.id.ticker = :ticker ", Stockdata.class);
		query.setParameter("ticker", ticker);

		List<Stockdata> lst = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return lst;
	}
	//getTemporalData - gets the temporal data 
	public List<Stockdata> extractTemporalData(String StartDate, String EndDate)
	{	
		em.getTransaction().begin();

	    TypedQuery<Stockdata> query = em.createQuery("SELECT st FROM Stockdata st WHERE st.id.stockDate BETWEEN :StartDate AND :EndDate ", Stockdata.class);
		query.setParameter("StartDate", StartDate);
		query.setParameter("EndDate", EndDate);

		List<Stockdata> lst = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return lst;
	}
	
	//extract all
	@Override
	public List<Stockdata> extract()
	{
		//em.getTransaction().begin();
		System.out.println("in extract....");
		//em.getTransaction().begin();
		/*TypedQuery<Stockdata> query = em.createQuery("SELECT st FROM Stockdata st ", Stockdata.class);
		List<Stockdata> lst = query.getResultList();*/
		//em.getTransaction().commit();
		//em.close();
		String q = "SELECT p from " + Stockdata.class.getName() + " p";
        Query query = em.createQuery(q);
        List<Stockdata> lst = query.getResultList();
       // em.getTransaction().commit();
        //em.close();
		System.out.println("extract done....");
		return lst;
	}
	
	@Override
	public List<Stockdata> getRealTimeData()
	{
		//em.getTransaction().begin();
		System.out.println("in extract....");
		//em.getTransaction().begin();
	/*	TypedQuery<Stockdata> query = em.createQuery("SELECT st FROM Stockdata st ", Stockdata.class);
		List<Stockdata> lst = query.getResultList();
*/		//em.getTransaction().commit();
		//em.close();
		//Working Query - returns all------------------------------
		/*String q = "SELECT p from " + Stockdata.class.getName() + " p";
        Query query = em.createQuery(q);
        List<Stockdata> lst = query.getResultList();*/
        //Working Query - returns all------------------------------
		
		String curr = new String();
    	final String DATE_FORMAT_NOW = "yyyyMMdd";	
    	Calendar cal = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
    	curr = sdf.format(cal.getTime());
    	System.out.println("Date:"+curr);
		
    	Query query1 = em.createQuery("select MAX(d.id.stockDate) FROM Stockdata d ");
    	List<String> dts= (List<String>)query1.getResultList();
    	Iterator it1 = dts.iterator();
    	curr=it1.next().toString();
    	System.out.println("max date string:" +  curr);
    	
		Query query = em.createQuery("select d FROM Stockdata d where d.id.stockDate = :CurrentDate");
        query.setParameter("CurrentDate", curr);
        List<Stockdata> lst=(List<Stockdata>) query.getResultList();
        List<Stockdata> modifylst = new ArrayList<Stockdata>();
        Iterator itr = lst.iterator();
        Random randomGenerator = new Random();
        while (itr.hasNext())
        {
        	Stockdata stk = (Stockdata) itr.next();
        	Stockdata stk1 = stk;
        	int randomChange = randomGenerator.nextInt(2);
        	boolean change = randomGenerator.nextBoolean();
        	if(change)
        	{
        		stk1.setHigh((stk.getHigh()+randomChange));
        	}else
        	{
        		stk1.setHigh((stk.getHigh()-randomChange));
        	}
        	modifylst.add(stk1);
        	
        }
        
        //em.getTransaction().commit();
		//em.close();
		System.out.println("extract done....");
		return modifylst;
	}
	
	public List<Stockdata> extractSpatialLocation(String location)
    {
            
            //em.getTransaction().begin();
            /*Query tick = em.createQuery("select s.stockDate,s.ticker,s.close,s.high,s.low,s.open,s.volume from ticker t, Stockdata s where t.ticker = s.ticker and( t.location like :location)");
            tick.setParameter("location",location);*/
            
            //TypedQuery<Stockdata> query=em.createQuery("select s.stockDate,s.ticker,s.close,s.high,s.low,s.open,s.volume from Ticker t, Stockdata s where t.Ticker = s.Ticker and( t.location like :location)", Stockdata.class);
            //Query query = em.createQuery("select d.id.ticker,d.open,d.close,d.high,d.volume,d.low FROM Stockdata d,Ticker m where m.ticker=d.id.ticker and m.country=:location");
            Query query = em.createQuery("select d FROM Stockdata d,Ticker m where m.ticker=d.id.ticker and m.country=:location");
            query.setParameter("location", location);
            List<Stockdata> ls=(List<Stockdata>) query.getResultList();
            
            /*List ls = query.getResultList();

                    Iterator it1 = ls.iterator();
                    while (it1.hasNext()){
                            
                            Object[] obj = (Object[]) it1.next();
                    }
*/          //em.getTransaction().commit();
            //em.close();
            return ls;
            /*Query query = em.createQuery("select s.ticker from ticker t, stockdata s where t.ticker = s.ticker and( t.location like 'USA')");
            //query.setParameter("location", location);
            List rs = query.getResultList();
            int size=rs.size();
            List<Stockdata> lst=new ArrayList<Stockdata>();
             for(int i=0;i<size;i++) {

               Object[] obj =  (Object[])rs.get(i);
               Ticker t = (Ticker) obj[1];
               Stockdata s = (Stockdata) obj[0];
               lst.add(s);
             }
             
             return lst;
*/                        
    }
	
	public List<Stockdata> extractSpatialIndustry(String industry)
    {
            Query query = em.createQuery("select d FROM Stockdata d,Ticker m where m.ticker=d.id.ticker and m.industry=:industry");
            query.setParameter("industry", industry);
            List<Stockdata> ls=(List<Stockdata>) query.getResultList();
            return ls;       
    }
	
	public List<Stockdata> extractSpatialSector(String sector)
    {
            Query query = em.createQuery("select d FROM Stockdata d,Ticker m where m.ticker=d.id.ticker and m.sector=:sector");
            query.setParameter("sector", sector);            
            List<Stockdata> ls=(List<Stockdata>) query.getResultList();            
            return ls;            
    }
	@Override
	public List<String> getTicker()
    {
            Query query = em.createQuery("select distinct m.ticker FROM Ticker m ");
            List<String> ls=(List<String>) query.getResultList();         
            return ls;       
    }
	@Override
	public List<String> getLocation()
    {
            Query query = em.createQuery("select distinct m.country FROM Ticker m ");
            List<String> ls=(List<String>) query.getResultList();         
            return ls;       
    }
	@Override
	public List<String> getSector()
    {
            Query query = em.createQuery("select distinct m.sector FROM Ticker m ");
            List<String> ls=(List<String>) query.getResultList();         
            return ls;       
    }
	@Override
	public List<String> getIndustry()
    {
            Query query = em.createQuery("select distinct m.industry FROM Ticker m ");
            List<String> ls=(List<String>) query.getResultList();         
            return ls;       
    }
}
