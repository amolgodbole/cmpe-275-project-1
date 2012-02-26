package com.convert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;

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
		Query query = em.createQuery("SELECT st FROM Stockdata st");
		List lst = query.getResultList();
		Iterator it = lst.iterator();
		while (it.hasNext()){
			Stockdata stockdata = (Stockdata) it.next();
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
		}

		}