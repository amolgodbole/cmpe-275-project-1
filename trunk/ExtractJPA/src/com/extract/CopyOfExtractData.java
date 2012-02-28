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

public class CopyOfExtractData {

	/**
	 * @param args
	 */
	EntityManager em;
	EntityManagerFactory emf;
	public CopyOfExtractData()
	{
		emf = Persistence.createEntityManagerFactory("ExtractModule");
		em = emf.createEntityManager();
	}
	
	//getSpatialData - gets the spatial data with region and range
	public void extract(String format, String Region, boolean range, String StartDate, String EndDate)
	{
		em.getTransaction().begin();
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
		em.getTransaction().commit();
		em.close();
	}
	//getSpatialData - gets all the spatial data for the region
	public void extract(String format, String Region)
	{
		
	}
	//getTemporalData - gets the temporal data 
	public ArrayList<Stockdata> extractTemporalData(String StartDate, String EndDate)
	{
		System.out.println("Extracting Temporal data....");
		em.getTransaction().begin();
		System.out.println("step0");
		
		/*
		//Working
		Query query = em.createQuery("SELECT st FROM Stockdata st WHERE st.id.stockDate BETWEEN '20080226' AND '20080227' ");
		*/
		
	    //Working
	    TypedQuery<Stockdata> query = em.createQuery("SELECT st FROM Stockdata st WHERE st.id.stockDate BETWEEN :StartDate AND :EndDate ", Stockdata.class);
		query.setParameter("StartDate", StartDate);
		query.setParameter("EndDate", EndDate);
		
		/*
		//Working
		TypedQuery<Stockdata> query = em.createQuery("SELECT st FROM Stockdata st WHERE st.id.stockDate = ?1", Stockdata.class);
		query.setParameter(1, StartDate);
		*/
		
		/*
		//Working
		TypedQuery<Stockdata> query = em.createQuery("SELECT st FROM Stockdata st WHERE st.id.stockDate BETWEEN '" + StartDate + "' AND '" + EndDate +"'", Stockdata.class);
		*/
		
		/*
		//Working
		TypedQuery<Stockdata> query = em.createQuery("SELECT st FROM Stockdata st WHERE st.id.stockDate = '" + StartDate + "'", Stockdata.class);
		*/
		
		/*
		//Working
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Stockdata> q = cb.createQuery(Stockdata.class);
		Root<Stockdata> stk = q.from(Stockdata.class);
		//q.select(stk);
		q.select(stk).where(cb.equal(stk.get("id").get("stockDate"), "20080225"));
		TypedQuery<Stockdata> query = em.createQuery(q);
		*/
		
		System.out.println("step1");
		List lst = query.getResultList();
		Iterator it = lst.iterator();
		ArrayList<Stockdata> st = new ArrayList<Stockdata>();
		System.out.println("step2");
		while (it.hasNext()){
			System.out.println("step3");
			Stockdata stockdata = (Stockdata) it.next();
			st.add(stockdata);
		}
		System.out.println("step4");
		//ConvertToJson con = new ConvertToJson();
		//con.encode(st);
		em.getTransaction().commit();
		em.close();
		System.out.println("Completed Extracting Temporal data....");
		return st;
	}
	
	//extract all
	public ArrayList<Stockdata> extract()
	{
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT st FROM Stockdata st");
		List lst = query.getResultList();
		Iterator it = lst.iterator();
		ArrayList<Stockdata> st = new ArrayList<Stockdata>();
		
		while (it.hasNext()){
			Stockdata stockdata = (Stockdata) it.next();
			st.add(stockdata);
		}
		//ConvertToJson con = new ConvertToJson();
		//con.encode(st);
		em.getTransaction().commit();
		em.close();
		return st;
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