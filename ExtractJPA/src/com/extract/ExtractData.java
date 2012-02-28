package com.extract;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.convert.ConvertToJson;
import com.convert.ConvertToXml;

import java.util.*;

/**
 * @author Nandish
 * Extracts data from database and returns a List<Stockdata>
 */
public class ExtractData {

	/**
	 * @param args
	 */
	EntityManager em;
	EntityManagerFactory emf;
	public ExtractData()
	{
		emf = Persistence.createEntityManagerFactory("ExtractModule");
		em = emf.createEntityManager();
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
	
	
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExtractModule");
		EntityManager em = emf.createEntityManager();
		try{
		em.getTransaction().begin();

		
		//converting to JSON
		Query query = em.createQuery("SELECT st FROM Stockdata st");
		
		List lst = query.getResultList();
		Iterator it = lst.iterator();
		ArrayList<Stockdata> st = new ArrayList<Stockdata>();
		
		while (it.hasNext()){
			Stockdata stockdata = (Stockdata) it.next();
			st.add(stockdata);
		}
		ConvertToJson con = new ConvertToJson();
		con.encode(st);
		//************************************************
		
	
		
		List lst = query.getResultList();
		Iterator it = lst.iterator();
		while (it.hasNext()){
			Stockdata stockdata = (Stockdata) it.next();
			ConvertToXml con = new ConvertToXml();
			con.convert(stockdata);
			ConvertToJson con1 = new ConvertToJson();
			con1.encode(stockdata);
			System.out.print("Date:"+stockdata.getId().getStockDate());
			System.out.print("Date:"+stockdata.getId().getTicker());
			System.out.print(" open:"+stockdata.getOpen());
			System.out.print(" High:"+stockdata.getHigh());
			System.out.print(" Low:"+stockdata.getLow());
			System.out.println(" Close:"+stockdata.getClose());
			System.out.println(" Volume:"+stockdata.getVolume());
		}
		
		em.getTransaction().commit();
		}
		catch(Exception e){
		System.out.println(e.getMessage());
		}
		finally{
		em.close();
		}
		}*/

}