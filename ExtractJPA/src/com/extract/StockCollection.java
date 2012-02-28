package com.extract;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nandish
 * 
 */
public class StockCollection {

	private List<Stockdata> list;
	
	public StockCollection()
	{
		list = new ArrayList<Stockdata>();
	}

	public List<Stockdata> getList() {
		return list;
	}

	public void setList(List<Stockdata> list) {
		this.list = list;
	}
	
	public void add(Stockdata st)
	{
		list.add(st);
	}
}
