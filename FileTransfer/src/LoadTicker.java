package com.dataload;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import com.extract.Ticker;

/**
 * @author Nandish
 * Persists One Record into database
 */
public class LoadTicker {

	/**
	 * @param args
	 */
	EntityManager em;
	EntityManagerFactory emf;
	String[] temp;
	public LoadTicker()
	{
		emf = Persistence.createEntityManagerFactory("ExtractModule");
		em = emf.createEntityManager();
	}
	
	public void beginTran()
	{
		em.getTransaction().begin();
	}
	
	public void insert(String record)
	{
		
		Ticker tick=new Ticker();
		
		temp = record.split(",");
		
		tick.setNumber(Integer.parseInt(temp[0]));
		tick.setTicker(temp[1]);
		tick.setCompany(temp[2]);
		tick.setSector(temp[3]);
		tick.setIndustry(temp[4]);
		tick.setCountry(temp[5]);
		tick.setMarketcap(Float.parseFloat(temp[6]));
		
/*		sk.setStockDate(temp[0]);
		sk.setTicker(temp[1]);
		stock.setId(sk);
		stock.setOpen(Double.parseDouble(temp[2]));
		stock.setHigh(Double.parseDouble(temp[3]));
		stock.setLow(Double.parseDouble(temp[4]));
		stock.setClose(Double.parseDouble(temp[5]));
		stock.setVolume(Integer.parseInt(temp[6]));	
*/	
		em.persist(tick);
	}
	
	public void closecon()
	{
		em.getTransaction().commit();
		em.close();
	}
	
	//code to insert only one record to the table
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	
			//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			EntityManager em;
			EntityManagerFactory emf;
			emf = Persistence.createEntityManagerFactory("LoadModule");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			Stockdata stock = new Stockdata();

			StockdataPK sk = new StockdataPK();
			sk.setStockDate("20090225");
			sk.setTicker("AAPL");
			stock.setId(sk);
			stock.setOpen(118.59);
			stock.setHigh(120.17);
			stock.setLow(116.664);
			stock.setClose(119.74);
			stock.setVolume(448847);
			
		
			em.persist(stock);
			
			
			
			em.getTransaction().commit();
			em.close();

	
			
				
	}
*/
}
