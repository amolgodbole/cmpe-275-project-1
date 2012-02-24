package com.extract;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.convert.ConvertToXml;
import com.hibernate.HibernateUtil;

public class ExtractModule {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Session session = null;
		 Transaction tx = null;
		
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExtractModule");
		//EntityManager em = emf.createEntityManager();
		
		try{
		//em.getTransaction().begin();
		//Select all the record from student table
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
		//Query query = session.createQuery("SELECT st FROM stockdata st");
		List list = session.createQuery("from StockData").list();	
		//List lst = query.getResultList();
		Iterator itt = list.iterator();
		/*ArrayList<StockData> StockList = new ArrayList<StockData>();
		
		while(it.hasNext()){
			StockData stock = (StockData) it.next();
			StockList.add(stock);
		}
		Iterator itt = StockList.iterator();
		ConvertToXml con = new ConvertToXml();
		con.convertList(StockList); */
		while (itt.hasNext()){
			StockData stock = (StockData) itt.next();
//			ArrayList<StockData> StockList = new ArrayList<StockData>();
//			StockList.add(stock);
			
			con.convertList(StockList);
			
			System.out.print("Stock Date:"+stock.stockKey.getStockDate());
			System.out.print("Ticker:"+stock.stockKey.getTicker());
			System.out.println("Open:"+stock.getOpen());
			System.out.println("High:"+stock.getHigh());
			System.out.println("Low:"+stock.getLow());
			System.out.println("Close:"+stock.getClose());
			System.out.println("Volume:"+stock.getVolume());
		}
		tx.commit();
		//session.close();
		}
		catch(Exception e){
		System.out.println(e.getMessage());
		}
		finally{
		
		}
		}

	}


