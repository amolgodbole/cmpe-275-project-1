package com.data.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.data.builder.IBuilder;
import com.data.builder.JsonBuilder;
import com.data.builder.XmlBuilder;
import com.data.entity.Stockdata;



/**
 * Session Bean implementation class StockProvider
 */
@Stateless
public class StockProvider implements StockProviderRemote, StockProviderLocal {

    /**
     * Default constructor. 
     */
	EntityManager em;
	EntityManagerFactory emf;
    public StockProvider() {
    	emf = Persistence.createEntityManagerFactory("ExtractModule");
		em = emf.createEntityManager();
    }

    public enum SerializationType{XML, JSON};
	
	public IBuilder get_builder(SerializationType type)
	{
		switch(type)
		{
			case XML:
				return new XmlBuilder();		//if type is XML, call XmlBuilder.
				
			case JSON:
				return new JsonBuilder();		//if type is JSON, call JsonBuilder
				
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
	
	public String getTemporalData(String format, String StartDate, String EndDate)
	{
		//ExtractData data = new ExtractData();
		return encode(extractTemporalData(StartDate, EndDate), format);
	}
	
	@Override
	public String getAllData(String format)
	{
		//ExtractData data = new ExtractData();
		System.out.println("get all data");
		return encode(extract(), format);
	}
	
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
	public List<Stockdata> extract()
	{
		em.getTransaction().begin();
		TypedQuery<Stockdata> query = em.createQuery("SELECT st FROM Stockdata st ", Stockdata.class);
		List<Stockdata> lst = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return lst;
	}
}
