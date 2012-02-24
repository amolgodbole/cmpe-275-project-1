package com.extract;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hibernate.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CreateData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			StockData stock = new StockData();
			//DateFormat dfm = new SimpleDateFormat("yyyyMMdd");
			//Date dt;
			//dt = dfm.parse("20080225");
			StockKey sk = new StockKey("20080225", "AAPL");
			stock.setStockKey(sk);
			stock.setOpen(118.59);
			stock.setHigh(120.17);
			stock.setLow(116.664);
			stock.setClose(119.74);
			stock.setVolume(448847);
			
			session.save(stock);
			
			session.flush();
			session.clear();
			tx.commit();

	
			
				
	}

}
