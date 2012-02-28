package com.extract;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.convert.ConvertToJson;
import com.convert.ConvertToXml;

import java.util.*;

/**
 * @author Nandish
 * Extracts all the records from the database. Select * from table
 * Use ExtractData instead
 */
public class ExtractRead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExtractModule");
		EntityManager em = emf.createEntityManager();
		try{
		em.getTransaction().begin();
		//Select all the record from student table
		/*
		Query query = em.createQuery("SELECT st FROM Student st");
		List lst = query.getResultList();
		Iterator it = lst.iterator();
		while (it.hasNext()){
			Student student = (Student) it.next();
			System.out.print("Id:"+student.getId());
			System.out.print(" Name:"+student.getSname());
			System.out.println(" Course:"+student.getScourse());
		}
		*/
		
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
		
		//converting to XML
		Query query1 = em.createQuery("SELECT st FROM Stockdata st");
		
		List lst1 = query.getResultList();
		
		Iterator it1 = lst.iterator();
		//ArrayList<Stockdata> st1 = new ArrayList<Stockdata>();
		HashMap<Integer, Stockdata> h = new HashMap<Integer, Stockdata>();
		HashSet<Stockdata> h1 = new HashSet<Stockdata>();
		
		while (it.hasNext()){
			Stockdata stockdata = (Stockdata) it.next();
			//st1.add(stockdata);
			h1.add(stockdata);
		}
		ConvertToXml con1 = new ConvertToXml();
		con1.convertObject(lst1);
	
		
		/*List lst = query.getResultList();
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
		}*/
		
		em.getTransaction().commit();
		}
		catch(Exception e){
		System.out.println(e.getMessage());
		}
		finally{
		em.close();
		}
		}

		}